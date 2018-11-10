package uy.edu.um.bbticg4.ui.controllers;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class HistorialReservasController {

    @Autowired
    private ReservaMgr reservaMgr;

    private List<Reserva> listaReservas = new LinkedList<>();

    @FXML
    private ListView<Reserva> Historial;

    private Restaurant resto;


    @FXML
    void displayReservas(ActionEvent event) {

        listaReservas = reservaMgr.getReservas(resto);

        ObservableList<Reserva> reservas = FXCollections.observableArrayList();

        for (int i = 0; i < listaReservas.size(); i++) {
            if (listaReservas.get(i).isFinalizada == true) {
                reservas.add(listaReservas.get(i));
            }
        }
        Historial.setItems(reservas);
        Historial.setCellFactory(new Callback<ListView<Reserva>, ListCell<Reserva>>() {
            @Override
            public ListCell<Reserva> call(ListView<Reserva> listView) {
                return new CustomListCellHistorial();
            }
        });
    }

    public void setResto(Restaurant resto){this.resto = resto;}

    public  Restaurant getResto(){return resto;}
}

}
