package org.example.assignment10;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class HelloApplication extends Application {

    private ObservableList<Employee> employees = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Management");

        // TableView to display employees
        TableView<Employee> table = new TableView<>(employees);

        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Employee, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType()));

        TableColumn<Employee, String> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(data ->
                new SimpleStringProperty(String.format("%.2f", data.getValue().calculateSalary())));

        table.getColumns().addAll(nameColumn, typeColumn, salaryColumn);

        // Form to add new employees
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("Full-time", "Part-time", "Contractor");

        TextField salaryField = new TextField();
        salaryField.setPromptText("Annual Salary / Hourly Rate");

        TextField hoursField = new TextField();
        hoursField.setPromptText("Hours Worked / Max Hours");

        Button addButton = new Button("Add Employee");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String type = typeComboBox.getValue();
            try {
                if (type.equals("Full-time")) {
                    double annualSalary = Double.parseDouble(salaryField.getText());
                    employees.add(new FullTimeEmployee(name, annualSalary));
                } else {
                    double hourlyRate = Double.parseDouble(salaryField.getText());
                    int hours = Integer.parseInt(hoursField.getText());
                    if (type.equals("Part-time")) {
                        employees.add(new PartTimeEmployee(name, hourlyRate, hours));
                    } else if (type.equals("Contractor")) {
                        employees.add(new Contractor(name, hourlyRate, hours));
                    }
                }
            } catch (Exception ex) {
                showAlert("Error", "Invalid input. Please check your entries.");
            }
        });

        // Remove selected employee
        Button removeButton = new Button("Remove Selected");
        removeButton.setOnAction(e -> {
            Employee selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                employees.remove(selected);
            }
        });

        // Layout
        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);
        form.add(new Label("Name:"), 0, 0);
        form.add(nameField, 1, 0);
        form.add(new Label("Type:"), 0, 1);
        form.add(typeComboBox, 1, 1);
        form.add(new Label("Salary / Rate:"), 0, 2);
        form.add(salaryField, 1, 2);
        form.add(new Label("Hours:"), 0, 3);
        form.add(hoursField, 1, 3);
        form.add(addButton, 0, 4);
        form.add(removeButton, 1, 4);

        VBox layout = new VBox(10, table, form);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }





    public static void main(String[] args) {
        launch();
    }
}


