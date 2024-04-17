package com.lacapsule.toolbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 320, 240);
        scene.getStylesheets().add(HelloApplication.class.getResource("style.css").toExternalForm());
        stage.setTitle("TOOLBOX");
        stage.setScene(scene);
        stage.show();

        Button runScriptButton = getScriptButton();

        vbox.getChildren().add(runScriptButton);
    }

    private static Button getScriptButton() {
        Button runScriptButton = new Button("Run Script");

        runScriptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ProcessBuilder pb = new ProcessBuilder("/usr/bin/bash", "./scripts/gathering.sh");
                pb.directory(new File("/home/$USER/GIT/TOOLBOX/target/classes/com/lacapsule/toolbox/scripts/"));
                try {
                    Process p = pb.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return runScriptButton;
    }

    public static void main(String[] args) {
        launch();
    }
}
