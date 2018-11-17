package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.exceptions.InvalidUserInformation;
import uy.edu.um.bbticg4.exceptions.UserAlreadyExists;
import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.ui.tools.JavaFXTools;

@Component
public class RegistroClienteController {

    @Autowired
    private ClienteFinalMgr cfmgr;

    @Autowired
    private JavaFXTools tools;

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
        stage.setResizable(false);
        stage.close();

    }

    @FXML
    void confirmation(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        if (namefield == null || lnameField == null || mailField == null || confirmMailField == null ||
                passField == null || confirmPassField == null || cellphoneField == null) {

        tools.showAlert(
                "Datos faltantes!",
                "No se ingresaron los datos necesarios para completar el ingreso.");

        } else {

        try {
            String fName = namefield.getText();
            String lName = lnameField.getText();
            String password = passField.getText(); //NO ES ALFANUMERICA, EDITAR LUEGO
            String confPass = confirmPassField.getText();
            String email = mailField.getText(); //NO ES ALFANUMERICA, EDITAR LUEGO
            String confEmail = confirmMailField.getText();
            String telefono = cellphoneField.getText();

            try {
                cfmgr.addClienteFinal(fName, lName, email, confEmail, telefono, password, confPass);
                tools.showAlert("Cliente agregado", "Cliente agregado correctamente");

                cerrar(event);

            } catch (InvalidUserInformation invalidUserInformation) {
                tools.showAlert(
                        "Informacion invalida !",
                        "Se encontro un error en los datos ingresados.");
            } catch (UserAlreadyExists userAlreadyExists) {
                tools.showAlert(
                        "Restaurante ya registrado !",
                        "El Restaurante indicado ya ha sido registrado en el sistema).");
            }
        } catch (NumberFormatException e) {

            tools.showAlert("Datos incorrectos !", "El RUC no tiene el formato esperado (numerico).");
            }
        }
    }

    @FXML
    public void cerrar(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.setResizable(false);
        stage.close();
    }
}
