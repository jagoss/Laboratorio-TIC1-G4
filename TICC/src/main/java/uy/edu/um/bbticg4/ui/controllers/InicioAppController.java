package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;

import java.io.IOException;

@Component
public class InicioAppController {

    @FXML
    private Button signInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void SignUp(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("RegistroCliente.fxml"));
        Stage stage = new Stage();
        Scene sceneLogIn = new Scene(root);
        sceneLogIn.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(sceneLogIn);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void signIn(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("LogIn.fxml"));
        Stage stage = new Stage();
        Scene sceneLogIn = new Scene(root);
        sceneLogIn.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(sceneLogIn);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }

}
