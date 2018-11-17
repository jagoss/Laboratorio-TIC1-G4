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
    private RadioMenuItem restOp;

    @FXML
    private RadioMenuItem adminOp;

    private Restaurant resto;
    private ClienteFinal cf;

    @FXML
    void confirmation(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        Stage stage = new Stage();

        if (userMail != null || userMail.getText().equals("")||
                userPass != null || userPass.getText().equals("")) {

            if (clientOp.isSelected()) {

                if (cfMgr.loginCorrecto(userMail.getText(), userPass.getText())) {

                    fxmlLoader.setLocation(ClienteFinalFiltroController.class.getResource("ClienteFinalFiltro.fxml"));
                    ClienteFinalFiltroController controller = Main.getContext().getBean(ClienteFinalFiltroController.class);
                    controller.setCf(cfMgr.getCliente(userMail.getText()));
                    Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("ClienteFinalFiltro.fxml"));

                    Scene sceneFiltroFinal = new Scene(root);
                    sceneFiltroFinal.getStylesheets().add("uy/edu/um/bbticg4/ui/images/busquedaResto.css");
                    stage.setScene(sceneFiltroFinal);
                    stage.show();

                    Node source = (Node)  event.getSource();
                    stage  = (Stage) source.getScene().getWindow();
                    stage.close();

                } else {
                    tools.showAlert("Datos incorrectos !", "Mail o contraseña incorrecta.");
                }
            } else if (restOp.isSelected()) {
                if(restoMgr.loginCorrecto(userMail.getText(), userPass.getText())){
                    resto = restoMgr.getRestaurant(userMail.getText());

                    if(resto.getFistLogin()) {
                        fxmlLoader.setLocation(RestoInfoEditController.class.getResource("RestoInfoEdit.fxml"));
                        RestoInfoEditController controller = Main.getContext().getBean(RestoInfoEditController.class);
                        controller.setResto(restoMgr.getRestaurant(userMail.getText()));
                        Parent root = fxmlLoader.load(
                                LogInController.class.getResourceAsStream("RestoInfoEdit.fxml"));
                        Scene sceneRestoMain = new Scene(root);
                        sceneRestoMain.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pantallaPrincipalResto.css");
                        stage.setScene(sceneRestoMain);
                        stage.setResizable(false);
                        stage.show();

                        Node source = (Node)  event.getSource();
                        stage  = (Stage) source.getScene().getWindow();
                        stage.close();
                    }else{
                        fxmlLoader.setLocation(MenuInicioRestoController.class.
                                getResource("MenuInicialResto.fxml"));

                        MenuInicioRestoController controller = Main.getContext().
                                getBean(MenuInicioRestoController.class);

                        controller.setResto(restoMgr.getRestaurant(userMail.getText()));
                        Parent root = fxmlLoader.load(
                                LogInController.class.getResourceAsStream("MenuInicialResto.fxml"));

                        Scene sceneRestoMain = new Scene(root);
                        sceneRestoMain.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pantallaPrincipalResto.css");
                        stage.setScene(sceneRestoMain);
                        stage.show();

                        Node source = (Node)  event.getSource();
                        stage  = (Stage) source.getScene().getWindow();
                        stage.close();
                    }

                }else {
                    tools.showAlert("Datos incorrectos !", "Mail o contraseña incorrecta.");
                }
            }else if (adminOp.isSelected()) {
                if (userMail.getText().equals("admin") && userPass.getText().equals("1234")) {

                    Parent root = fxmlLoader.load(
                            LogInController.class.getResourceAsStream("AdminPrincipal.fxml"));

                    Scene sceneAdmin = new Scene(root);
                    sceneAdmin.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
                    stage.setScene(sceneAdmin);
                    stage.show();

                    Node source = (Node)  event.getSource();
                    stage  = (Stage) source.getScene().getWindow();
                    stage.close();

                } else {
                    tools.showAlert("Datos incorrectos !", "Mail o contraseña incorrecta.");
                }
            }else{
                tools.showAlert("Falta el tipo de usuario!", "Seleccione el tipo de usuario.");
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

        Scene sceneLogIn = new Scene(root);
        sceneLogIn.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(sceneLogIn);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }


    @FXML
    void selectedAdmin(ActionEvent event) {
        selectedUser(event);
        UserType.setText("Administrador");

    }

    @FXML
    void selectedClient(ActionEvent event) {
        selectedUser(event);
        UserType.setText("Cliente");

    }

    @FXML
    void selectedResto(ActionEvent event) {
        selectedUser(event);
        UserType.setText("Restaurante");

    }

    @FXML
    public void selectedUser(ActionEvent actionEvent) {
        ToggleGroup toggleGroup = new ToggleGroup();
        clientOp.setToggleGroup(toggleGroup);
        restOp.setToggleGroup(toggleGroup);
        adminOp.setToggleGroup(toggleGroup);
    }

}

