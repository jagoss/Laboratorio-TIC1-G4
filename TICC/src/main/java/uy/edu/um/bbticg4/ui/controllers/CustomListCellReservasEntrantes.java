package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.entities.ClienteFinal;
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
import java.time.format.DateTimeFormatter;
import uy.edu.um.bbticg4.ui.controllers.ReservasEntrantesController;

@Component
public class CustomListCellReservasEntrantes extends ListCell<Reserva>{


        private HBox content;

        private Text cantidadClientes;
        private Text hora;
        private Text client;

        private Button confirmar;
        private Button negar;
        @Autowired
        private ClienteFinalMgr cfmgr;
        @Autowired
        private ReservasEntrantesController cre;


    public CustomListCellReservasEntrantes(ClienteFinalMgr cfmgr) {
            super();

            this.cfmgr = cfmgr;
            cantidadClientes = new Text();
            hora = new Text();
            client = new Text();
            client.setFont(Font.font("System", FontWeight.BOLD, 20.0));

            confirmar = new Button();
            confirmar.setText("Confirmar"); //Poner visto de wsp y color verde
            negar = new Button();
            negar.setText("Rechazar"); //Poner cruz y color rojo



/*
        confirmar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                cre.displayReservas(event);

            }
        });

        negar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                cre.displayReservas(event);

            }
        });*/

            VBox vBoxMID = new VBox(client, hora, cantidadClientes);
            VBox vBoxBotones = new VBox(confirmar, negar);

            content = new HBox(new Label("[ImageUser]"), vBoxMID, vBoxBotones);
            content.setSpacing(15);
            content.setPadding(new Insets(8,8,8,8));

        }

        @Override
        protected void updateItem(Reserva item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) { // <== test for null item and empty parameter

                ClienteFinal clienteDeRes = item.getCf();

                cantidadClientes.setText("Cantidad de personas: " + item.getCantidad().toString());
                hora.setText("Hora de Reserva: " + item.getHoraReserva().toString());
                client.setText("Cliente: " + clienteDeRes.getFirstName() + " " + clienteDeRes.getLastName());
                setGraphic(content);


            } else {
                setGraphic(null);
            }
        }
    }



