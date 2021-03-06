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
public class AdminPrincipalController {

    @FXML
    private Button RegistrarRestauranteButton;

    @FXML
    private Button backButton;

    @FXML
    private Button backdoorButton;

    @FXML
    void goBack(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(InicioAppController.class.getResourceAsStream("InicioApp.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void registrarRestaurante(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(AdminRegistroRestauranteController.class.getResourceAsStream("AdminRegistroRestaurante.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void goToFilter(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(ClienteFinalFiltroController.class.getResourceAsStream("ClienteFinalFiltro.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void checkDebt(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(ListaDeudasController.class.getResourceAsStream("ListaDeudas.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }

}
