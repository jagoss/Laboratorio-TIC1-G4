package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import uy.edu.um.MainAdmin;

@Component
public class AdminPrincipalController {

    @FXML
    private Button RegistrarRestauranteButton;

    @FXML
    void registrarRestaurante(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(MainAdmin.getContext()::getBean);

        Parent root = fxmlLoader.load(AdminRegistroRestauranteController.class.getResourceAsStream("AdminRegistroRestaurante.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
