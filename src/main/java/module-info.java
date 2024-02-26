module ru.vorotov.ooap2_lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.vorotov.ooap2_lab1 to javafx.fxml;
    exports ru.vorotov.ooap2_lab1;
}