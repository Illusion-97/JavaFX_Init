module com.example.javafx_init {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_init to javafx.fxml;
    exports com.example.javafx_init;
    exports com.example.javafx_init.controllers;
    opens com.example.javafx_init.controllers to javafx.fxml;
}