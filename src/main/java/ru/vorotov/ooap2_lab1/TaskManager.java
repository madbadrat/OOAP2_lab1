package ru.vorotov.ooap2_lab1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    @Getter
    List<Task> tasks = new ArrayList<>();
    public static int amountOfTasks = 0;

    public void createTask(Task task) {
        tasks.add(task);
        amountOfTasks++;
    }

    public void editTask(int id, String newType, String newTitle, String newDescription) {
        tasks.get(id).setType(newType);
        tasks.get(id).setDescription(newDescription);
        tasks.get(id).setTitle(newTitle);
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }
}
