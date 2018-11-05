package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.ui.controllers.AdminRegistroRestauranteController;

import java.io.IOException;

@Component
public class MenuInicioRestoController {

    @Autowired
    private RestaurantMgr restoMgr;

    @FXML
    private Button reservasEntrantes;

    @FXML
    private Button estadoReservas;

    @FXML
    private Button editarDatos;

    @FXML
    private Button Return;

    private Restaurant resto;

    @FXML
    void Return(ActionEvent event) {

    }

    @FXML
    void editarDatos(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        if(resto.getFistLogin()) {

            fxmlLoader.setLocation(RestoInfoEditController.class.getResource("RestoInfoEdit.fxml"));
            RestoInfoEditController controller = Main.getContext().getBean(RestoInfoEditController.class);
            controller.setResto(resto);
            Parent root = fxmlLoader.load(
                    MenuInicioRestoController.class.getResourceAsStream("RestoInfoEdit.fxml"));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    void estadoReservas(ActionEvent event) {

    }

    @FXML
    void reservasEntrantes(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        fxmlLoader.setLocation(ReservasEntrantesController.class.getResource("ReservasEntrantes.fxml"));
        ReservasEntrantesController controller = Main.getContext().getBean(ReservasEntrantesController.class);
        controller.setResto(resto);

        Parent root = fxmlLoader.load(
                MenuInicioRestoController.class.getResourceAsStream("ReservasEntrantes.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

    }

    public Restaurant getResto() {
        return resto;
    }

    public void setResto(Restaurant resto) {
        this.resto = resto;
    }
}
