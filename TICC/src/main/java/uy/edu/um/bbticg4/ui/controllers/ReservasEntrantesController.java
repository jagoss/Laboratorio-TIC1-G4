package uy.edu.um.bbticg4.ui.controllers;

import javafx.*;
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
import uy.edu.um.bbticg4.exceptions.TipoComidaException;
import uy.edu.um.bbticg4.service.ReservaMgr;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.util.LinkedList;
import java.util.List;

@Component
public class ReservasEntrantesController {

    @Autowired
    private ReservaMgr reservaMgr;

    private List<Reserva> listaReservas = new LinkedList<>();

    @FXML
    private ListView<Reserva> listaReservasEntrantes;

    private Restaurant resto;

    @FXML
    private Button refresh;

    @FXML
    public void initialize() {
        refresh.fire();
    }

    @FXML
    void displayReservas (ActionEvent event) {
//limpiar
        listaReservas = reservaMgr.getReservas(resto);

        ObservableList<Reserva> reservas = FXCollections.observableArrayList();

        for (int i = 0; i < listaReservas.size(); i++) {
            reservas.add(listaReservas.get(i));
        }
        listaReservasEntrantes.setItems(reservas);
        listaReservasEntrantes.setCellFactory(new Callback<ListView<Reserva>, ListCell<Reserva>>() {
            @Override
            public ListCell<Reserva> call(ListView<Reserva> listView) {
                return new CustomListCellReservasEntrantes();
            }
        });
    }

    public void setResto(Restaurant resto){this.resto = resto;}

    public  Restaurant getResto(){return resto;}
}
