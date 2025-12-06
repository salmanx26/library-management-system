package com.example.librarymanagementsystem;

import javafx.fxml.FXML;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.io.IOException;
import javafx.event.ActionEvent;

public class DashboardController {

    @FXML
    public void onLogoutClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Library System");
    }

    @FXML
    public void onAddBookClick() {
        System.out.println("Add Book Clicked");
    }

    @FXML
    public void onViewBooksClick() {
        System.out.println("View Books Clicked");
    }

    @FXML
    public void onIssueBookClick() {
        System.out.println("Issue Book Clicked");
    }

    @FXML
    public void onReturnBookClick() {
        System.out.println("Return Book Clicked");
    }
}
