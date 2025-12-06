package com.example.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField passwordTextField; // For toggling visibility

    @FXML
    private Button loginButton;

    @FXML
    private Button togglePasswordButton;

    private boolean isPasswordVisible = false;

    @FXML
    protected void onLoginButtonClick() {
        // In a real app, validation would happen here
        System.out.println("Login button clicked! Redirecting to dashboard...");

        try {
            // Get the current stage from the login button
            javafx.stage.Stage stage = (javafx.stage.Stage) loginButton.getScene().getWindow();

            // Load the dashboard view
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(
                    HelloApplication.class.getResource("dashboard-view.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load(), 1200, 800); // Larger size for
                                                                                             // dashboard

            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setTitle("Library System - Dashboard");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onTogglePasswordClick() {
        isPasswordVisible = !isPasswordVisible;
        if (isPasswordVisible) {
            passwordTextField.setText(passwordField.getText());
            passwordTextField.setVisible(true);
            passwordField.setVisible(false);
        } else {
            passwordField.setText(passwordTextField.getText());
            passwordField.setVisible(true);
            passwordTextField.setVisible(false);
        }
    }
}
