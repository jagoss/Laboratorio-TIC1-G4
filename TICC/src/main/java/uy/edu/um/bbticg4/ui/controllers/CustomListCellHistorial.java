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


public class CustomListCellHistorial extends ListCell<Reserva>{
    private  VBox realContent;
    private  VBox data;
    private HBox content;
    private HBox headline;


    private Text cantidadClientes;
    private Text hora;
    private Text client;
    private Text asistio;


    public CustomListCellHistorial() {
        super();

        client = new Text();
        hora = new Text();
        asistio = new Text();
        cantidadClientes = new Text();
        headline = new HBox(new Label("Reserva de"), client);
        client.setFont(Font.font("System", FontWeight.BOLD, 20.0));
        headline.setSpacing(5.0);

        data = new VBox(client, hora, cantidadClientes);
        content = new HBox(new Label("[Graphic]"),data );
        realContent = new VBox(headline, content);

    }

    @Override
    protected void updateItem(Reserva item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null && !empty) { // <== test for null item and empty parameter
            client.setText("Cliente: " + item.getCf().getFirstName() +" " + item.getCf().getLastName());
            hora.setText("Hora de la reserva: " + item.getHoraReserva().toString());
            cantidadClientes.setText("Cantidad de clientes: " + item.getCantidad().toString());
            if(item.isAsistio() == true){
                asistio.setText("Asistio");
            } else {
                asistio.setText("No asistio");
            }
            setGraphic(content);
        } else {
            setGraphic(null);
        }
    }


}
