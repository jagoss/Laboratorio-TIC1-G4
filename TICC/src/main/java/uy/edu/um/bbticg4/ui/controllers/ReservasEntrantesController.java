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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.exceptions.TipoComidaException;
import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.ReservaMgr;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class ReservasEntrantesController {

    @Autowired
    private ReservaMgr reservaMgr;

    @Autowired
    private ClienteFinalMgr cfmgr;

    private List<Reserva> listaReservas = new LinkedList<>();

    @FXML
    private ListView<Reserva> listaReservasEntrantes;

    private Restaurant resto;

    @FXML
    private Button refresh;

    @FXML
    private Button salir;

    @FXML
    public void initialize() {
        refresh.fire();
    }


    @FXML
    void displayReservas(ActionEvent event) {
        listaReservasEntrantes.getItems().clear();
        ReservasEntrantesController nuevaREC = this;

        listaReservas = reservaMgr.getReservas(resto);

        ObservableList<Reserva> reservas = FXCollections.observableArrayList();

        for (int i = 0; i < listaReservas.size(); i++) {
            if(!listaReservas.get(i).isFinalizada() && !listaReservas.get(i).isConfirmada()) {
                reservas.add(listaReservas.get(i));
            }
        }
        listaReservasEntrantes.setItems(reservas);

        listaReservasEntrantes.setCellFactory(new Callback<ListView<Reserva>, ListCell<Reserva>>() {
            @Override
            public ListCell<Reserva> call(ListView<Reserva> listView) {
                return new CustomListCellReservasEntrantes(cfmgr, nuevaREC, reservaMgr);
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

    public void setResto(Restaurant resto) {
        this.resto = resto;
    }

    public Restaurant getResto() {
        return resto;
    }
}
