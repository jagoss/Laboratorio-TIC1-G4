package uy.edu.um.bbticg4.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.ReservaMgr;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Component
public class HistorialReservasController {

    @Autowired
    private ReservaMgr reservaMgr;

    private List<Reserva> listaReservas = new LinkedList<>();

    @FXML
    private ListView<Reserva> historial;

    private Restaurant resto;



    @FXML
    public void initialize() {

        listaReservas = reservaMgr.getReservas(resto);
        HistorialReservasController controller = this;
        ObservableList<Reserva> reservas = FXCollections.observableArrayList();

        for (int i = 0; i < listaReservas.size(); i++) {
            if (listaReservas.get(i).isFinalizada() == true) {
                reservas.add(listaReservas.get(i));
            }
        }
        historial.setItems(reservas);
        historial.setCellFactory(new Callback<ListView<Reserva>, ListCell<Reserva>>() {
            @Override
            public ListCell<Reserva> call(ListView<Reserva> listView) {
                return new CustomListCellHistorial();
            }
        });
    }

    @FXML
    void salir(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(ReservasEntrantesController.class.getResourceAsStream("MenuInicialResto.fxml"));
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

    public void setResto(Restaurant resto){this.resto = resto;}

    public  Restaurant getResto(){return resto;}
}


