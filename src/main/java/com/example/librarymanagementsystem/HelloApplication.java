package com.example.librarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        // Set scene size to a reasonable default for desktop
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.setTitle("Library System");
        stage.setScene(scene);
        stage.show();
    }
}
