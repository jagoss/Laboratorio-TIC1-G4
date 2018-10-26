package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.RestaurantMgr;

public class LogInController {

    @Autowired
    private RestaurantMgr restoMgr;

    @Autowired
    private ClienteFinalMgr cfMgr;

    @FXML
    private Button InicioButton;

    @FXML
    private Button goBackButton;

    @FXML
    private TextField userMail;

    @FXML
    private PasswordField userPass;

    @FXML
    private ChoiceBox<?> opcionLog;

    @FXML
    void confirmation(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {

    }

}

