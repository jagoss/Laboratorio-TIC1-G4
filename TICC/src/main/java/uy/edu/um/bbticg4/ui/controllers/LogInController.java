package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.RestaurantMgr;

import java.io.IOException;

@Component
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
    private MenuButton UserType;

    @FXML
    private RadioMenuItem clientOp;

    @FXML
    private RadioMenuItem RestOp;

    @FXML
    private RadioMenuItem AdminOp;

    @FXML
    void confirmation(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("ClienteFinalFiltro.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("InicioApp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }




}

