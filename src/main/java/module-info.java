module org.example.assignment10 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires com.almasb.fxgl.all;

    opens org.example.assignment10 to javafx.fxml;
    exports org.example.assignment10;
}