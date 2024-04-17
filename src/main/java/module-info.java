module com.lacapsule.toolbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lacapsule.toolbox to javafx.fxml;
    exports com.lacapsule.toolbox;
}