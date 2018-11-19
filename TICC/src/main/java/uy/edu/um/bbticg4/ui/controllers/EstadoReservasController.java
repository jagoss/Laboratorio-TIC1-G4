package uy.edu.um.bbticg4.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.ReservaMgr;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.util.LinkedList;
import java.util.List;

@Component
public class EstadoReservasController {

    @Autowired
    private ReservaMgr reservaMgr;

    @Autowired
    private ClienteFinalMgr cfmgr;

    @FXML
    private Button refresh;

    @FXML
    private ListView<Reserva> listaReservasEntrantes;

    private List<Reserva> listaReservas = new LinkedList<>();

    private Restaurant resto;

    @FXML
    public void initialize() {

        listaReservas = reservaMgr.getReservas(resto);

        ObservableList<Reserva> reservas = FXCollections.observableArrayList();

        for (int i = 0; i < listaReservas.size(); i++) {
            if (!listaReservas.get(i).isFinalizada() && listaReservas.get(i).isConfirmada()) {
                reservas.add(listaReservas.get(i));
            }
        }
        listaReservasEntrantes.setItems(reservas);

        listaReservasEntrantes.setCellFactory(new Callback<ListView<Reserva>, ListCell<Reserva>>() {
            @Override
            public ListCell<Reserva> call(ListView<Reserva> listView) {
                return new CustomListCellEstadoReservas(cfmgr);
            }
        });
    }

    @FXML
    void refresh (ActionEvent event){

    }
}