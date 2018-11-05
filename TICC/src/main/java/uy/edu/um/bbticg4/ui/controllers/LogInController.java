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
import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.entities.ClienteFinal;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.ui.tools.JavaFXTools;

import java.io.IOException;

@Component
public class LogInController {

    @Autowired
    private RestaurantMgr restoMgr;

    @Autowired
    private ClienteFinalMgr cfMgr;

    @Autowired
    private JavaFXTools tools;

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

    private Restaurant resto;
    private ClienteFinal cf;

    @FXML
    void confirmation(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        Stage stage = new Stage();

        if (userMail != null || userPass != null) {

            if (clientOp.isSelected()) {
                if (cfMgr.loginCorrecto(userMail.getText(), userPass.getText())) {

                    fxmlLoader.setLocation(ClienteFinalFiltroController.class.getResource("ClienteFinalFiltro.fxml"));
                    ClienteFinalFiltroController controller = Main.getContext().getBean(ClienteFinalFiltroController.class);
                    controller.setCf(cfMgr.getCliente(userMail.getText()));
                    Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("ClienteFinalFiltro.fxml"));
                    stage.setScene(new Scene(root));
                    stage.show();

                } else {
                    tools.showAlert("Datos incorrectos !", "Mail o contraseña incorrecta.");
                }
            } else if (RestOp.isSelected()) {
                if(restoMgr.loginCorrecto(userMail.getText(), userPass.getText())){


                    //agregar pantalla principal de restaurant

                }else {
                    tools.showAlert("Datos incorrectos !", "Mail o contraseña incorrecta.");
                }
            }else if (AdminOp.isSelected()) {
                if (userMail.getText().equals("admin") && userPass.getText().equals("1234")) {

                    Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("AdminPrincipal.fxml"));
                    stage.setScene(new Scene(root));
                    stage.show();

                } else {
                    tools.showAlert("Datos incorrectos !", "Mail o contraseña incorrecta.");
                }
            }
        } else{
            tools.showAlert("Campos vacios!", "Ingrese los datos por favor.");
        }
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

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

