module com.example.finale {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires com.almasb.fxgl.all;
    requires javafx.media;

    opens com.example.finale to javafx.fxml;
    exports com.example.finale;
}