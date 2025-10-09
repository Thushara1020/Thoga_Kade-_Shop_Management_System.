package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void loginOnAction(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.equals("Thushara") && password.equals("1234")) {
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_form_fxml.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Dashboard");
            stage.show();
        } else {
            System.out.println("Login Failed");
        }

    }

}
