package uy.edu.um.bbticg4.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.springframework.stereotype.Component;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.ui.controllers.CustomListCell;

@Component
public class ReservasEntrantesController {

    private Restaurant resto;

    @FXML
    private ListView<Reserva> listaReservasEntrantes;


    ObservableList<Restaurant> resultados = FXCollections.observableArrayList();

            for (int i = 0; i < restoPorBarrio.size(); i++) {
        resultados.add(restoPorBarrio.get(i));
    }
            listaRestaurantes.setItems(resultados);

            listaRestaurantes.setCellFactory(new Callback<ListView<Restaurant>, ListCell<Restaurant>>() {
        @Override
        public ListCell<Restaurant> call(ListView<Restaurant> listView) {
            return new CustomListCell();
        }
    }
     public void setResto(Restaurant resto){this.resto = resto; }
     public Restaurant getResto(){return resto;}
}
