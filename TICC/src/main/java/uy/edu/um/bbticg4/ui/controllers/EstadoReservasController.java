package uy.edu.um.bbticg4.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.springframework.stereotype.Component;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;

@Component
public class EstadoReservasController {

    @FXML
    private Button refresh;


    @FXML
    private ListView<Reserva> listaReservasEntrantes;

    @FXML
    public initialize() {

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


        @FXML
        void refresh (ActionEvent event){

        }
    }
}