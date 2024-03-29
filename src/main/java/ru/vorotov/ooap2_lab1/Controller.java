package ru.vorotov.ooap2_lab1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ChoiceBox<String> typeChoiceBox;
    @FXML
    private TextField titleField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField idField;
    @FXML
    private TextArea textArea;
    @FXML
    private Label editLabel;

    private final String[] types = {"срочно", "не срочно"};
    private TaskManager taskManager;

    public void onAddButtonClick(ActionEvent actionEvent) {
        textArea.clear();
        taskManager.createTask(new Task(TaskManager.amountOfTasks, typeChoiceBox.getValue(), titleField.getText(), descriptionField.getText()));

        updateTextArea();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeChoiceBox.getItems().addAll(types);
        taskManager = new TaskManager();
    }

    public void onCloneButtonClick(ActionEvent actionEvent) {
        textArea.clear();
        Task oldTask = taskManager.getTask(Integer.parseInt(idField.getText()));
        taskManager.createTask(new Task(
                TaskManager.amountOfTasks,
                oldTask.getType(),
                oldTask.getTitle(),
                oldTask.getDescription(),
                new ArrayList<>(oldTask.getDescriptionHistory())
                )
        );

        updateTextArea();
    }

    public void onEditButtonClick(ActionEvent actionEvent) {
        editLabel.setText("Режим редактирования");
        Task editableTask = taskManager.getTask(Integer.parseInt(idField.getText()));
        typeChoiceBox.setValue(editableTask.getType());
        titleField.setText(editableTask.getTitle());
        descriptionField.setText(editableTask.getDescription());
    }

    public void onEndButtonClick(ActionEvent actionEvent) {
        if (editLabel.getText().equals("Режим редактирования")) {
            editLabel.setText("");
            textArea.clear();
            taskManager.editTask(
                    Integer.parseInt(idField.getText()),
                    typeChoiceBox.getValue(),
                    titleField.getText(),
                    descriptionField.getText()
            );

            updateTextArea();
        }
    }

    public void onHistoryButtonClick(ActionEvent actionEvent) {
        System.out.println(taskManager.getTask(Integer.parseInt(idField.getText())).getDescriptionHistory().toString());
    }

    private void updateTextArea() {
        for (int i = 0; i < taskManager.getTasks().size(); i++) {
            textArea.appendText(taskManager.getTasks().get(i).toString());
        }
    }
}
