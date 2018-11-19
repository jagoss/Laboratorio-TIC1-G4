package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
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
    private Button historialReservas;

    @FXML
    private Button deudaPend;

    @FXML
    private Button Return;

    @FXML
    private Text tituloResto;

    private Restaurant resto;

    @FXML
    public void initialize(){ tituloResto.setText(resto.getNombreFantasia()); }

    @FXML
    void HistorialReservas(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        fxmlLoader.setLocation(HistorialReservasController.class.getResource("HistorialReservas.fxml"));
        HistorialReservasController controller = Main.getContext().getBean(HistorialReservasController.class);
        controller.setResto(resto);

        Parent root = fxmlLoader.load(
                MenuInicioRestoController.class.getResourceAsStream("HistorialReservas.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pantallaPrincipalResto.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }


    @FXML
    void Return(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        Parent root = fxmlLoader.load(MenuInicioRestoController.class.getResourceAsStream("InicioApp.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void editarDatos(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        fxmlLoader.setLocation(RestoInfoEditController.class.getResource("RestoInfoEdit.fxml"));
        RestoInfoEditController controller = Main.getContext().getBean(RestoInfoEditController.class);
        controller.setResto(resto);
        Parent root = fxmlLoader.load(
                MenuInicioRestoController.class.getResourceAsStream("RestoInfoEdit.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pantallaPrincipalResto.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void estadoReservas(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        fxmlLoader.setLocation(EstadoReservasController.class.getResource("EstadoReservas.fxml"));
        EstadoReservasController controller = Main.getContext().getBean(EstadoReservasController.class);
        controller.setResto(resto);
        Parent root = fxmlLoader.load(
                MenuInicioRestoController.class.getResourceAsStream("EstadoReservas.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pantallaPrincipalResto.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void reservasEntrantes(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        fxmlLoader.setLocation(ReservasEntrantesController.class.getResource("ReservasEntrantes.fxml"));
        ReservasEntrantesController controller = Main.getContext().getBean(ReservasEntrantesController.class);
        controller.setResto(resto);

        Parent root = fxmlLoader.load(MenuInicioRestoController.class.getResourceAsStream("ReservasEntrantes.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pantallaPrincipalResto.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void deudaPend(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        fxmlLoader.setLocation(DeudaVentanaController.class.getResource("DeudaVentana.fxml"));
        DeudaVentanaController controller = Main.getContext().getBean(DeudaVentanaController.class);
        controller.setResto(resto);

        Parent root = fxmlLoader.load(
                MenuInicioRestoController.class.getResourceAsStream("DeudaVentana.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pantallaPrincipalResto.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public Restaurant getResto() {
        return resto;
    }

    public void setResto(Restaurant resto) {
        this.resto = resto;
    }
}
