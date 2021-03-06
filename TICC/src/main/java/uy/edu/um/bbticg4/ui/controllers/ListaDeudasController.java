package uy.edu.um.bbticg4.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
public class ListaDeudasController {


    @Autowired
    private RestaurantMgr restoMgr;

    List<Restaurant> restoPorDeuda = new LinkedList<>();

    @FXML
    private TableView<Restaurant> tablaDeudores;

    @FXML
    private TableColumn<Restaurant, String> Tname;

    @FXML
    private TableColumn<Restaurant, String> TfantasyName;

    @FXML
    private TableColumn<Restaurant, String> Temail;

    @FXML
    private TableColumn<Restaurant, String> Tphone;

    @FXML
    private TableColumn<Restaurant, BigDecimal> Tdebt;

    @FXML
    private Button updateB;

    @FXML
    private Button backB;

    @FXML
    public void initialize(){

        Tname.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("name"));
        TfantasyName.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("nombreFantasia"));
        Temail.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("email"));
        Tphone.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("cellphone"));
        Tdebt.setCellValueFactory(new PropertyValueFactory<Restaurant, BigDecimal>("deuda"));

        restoPorDeuda = restoMgr.filtrarRestosPorDeuda(BigDecimal.valueOf(0.0));

        ObservableList<Restaurant> resultados = FXCollections.observableArrayList();
        for (int i = 0; i < restoPorDeuda.size(); i++) { resultados.add(restoPorDeuda.get(i)); }

        tablaDeudores.setItems(resultados);

    }

    @FXML
    void updateDebt(ActionEvent event) {
        /*
        Tname.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("name"));
        TfantasyName.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("nombreFantasia"));
        Temail.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("email"));
        Tphone.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("cellphone"));
        Tdebt.setCellValueFactory(new PropertyValueFactory<Restaurant, BigDecimal>("deuda"));
        */
        restoPorDeuda = restoMgr.filtrarRestosPorDeuda(BigDecimal.valueOf(0.0));

        ObservableList<Restaurant> resultados = FXCollections.observableArrayList();
        for (int i = 0; i < restoPorDeuda.size(); i++) { resultados.add(restoPorDeuda.get(i)); }

        tablaDeudores.setItems(resultados);


    }

    @FXML
    void volver(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(ListaDeudasController.class.getResourceAsStream("AdminPrincipal.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
        stage.close();
    }

}