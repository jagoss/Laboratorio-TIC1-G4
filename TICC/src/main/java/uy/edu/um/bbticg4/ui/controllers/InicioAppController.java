package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioAppController {

    @FXML
    private Button signInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void SignUp(ActionEvent event) {

    }

    @FXML
    void signIn(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
       // fxmlLoader.setControllerFactory(NUEVO MAIN?????.getContext()::getBean); NUEVO MAIN????

        Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("LogIn.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

}
