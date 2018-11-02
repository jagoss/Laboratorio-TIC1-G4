package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class RegistroClienteController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField namefield;

    @FXML
    private TextField lnameField;

    @FXML
    private TextField cellphoneField;

    @FXML
    private TextField mailField;

    @FXML
    private TextField confirmMailField;

    @FXML
    private TextField passField;

    @FXML
    private TextField confirmPassField;

    @FXML
    void cancelation(ActionEvent event) {

        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confirmation(ActionEvent event) {

    }

}
