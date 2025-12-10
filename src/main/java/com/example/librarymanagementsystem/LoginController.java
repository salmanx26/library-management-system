package com.example.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import java.io.IOException;

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
    public void initialize() {
        if (loginButton == null) {
            System.err.println("Severe Error: loginButton was not injected! Check FXML fx:id.");
        }

        // Pre-fill credentials for testing
        usernameField.setText("admin");
        passwordField.setText("password");
    }

    @FXML
    protected void onLoginButtonClick() {
        if (loginButton == null) {
            System.err.println("Error: loginButton is null during click event.");
            return;
        }

        String username = usernameField.getText();
        // Get password from the visible field if it's currently shown, otherwise from
        // the password field
        String password = isPasswordVisible ? passwordTextField.getText() : passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please enter both username and password.");
            return;
        }

        // Validate credentials
        if ("admin".equals(username) && "password".equals(password)) {
            System.out.println("Login successful! Redirecting to dashboard...");
            try {
                // Get the current stage from the login button
                Stage stage = (Stage) loginButton.getScene().getWindow();

                // Load the dashboard view
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1200, 800); // Larger size for dashboard

                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setTitle("Library System - Dashboard");
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "System Error", "Could not load the dashboard.\n" + e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    protected void onTogglePasswordClick() {
        isPasswordVisible = !isPasswordVisible;
        if (isPasswordVisible) {
            passwordTextField.setText(passwordField.getText());
            passwordTextField.setVisible(true);
            passwordTextField.setManaged(true);
            passwordField.setVisible(false);
            passwordField.setManaged(false);
        } else {
            passwordField.setText(passwordTextField.getText());
            passwordField.setVisible(true);
            passwordField.setManaged(true);
            passwordTextField.setVisible(false);
            passwordTextField.setManaged(false);
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
