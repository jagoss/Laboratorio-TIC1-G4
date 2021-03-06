package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;


import javafx.scene.layout.*;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.ReservaMgr;
import uy.edu.um.bbticg4.service.entities.ClienteFinal;
import uy.edu.um.bbticg4.service.entities.Reserva;


import javafx.scene.layout.HBox;

import uy.edu.um.bbticg4.ui.tools.JavaFXTools;


public class CustomListCellReservasEntrantes extends ListCell<Reserva>{


    private HBox content;

    private Text cantidadClientes;
    private Text hora;
    private Text client;

    private Button confirmar;
    private Button negar;

    private ReservaMgr reservaMgr;
    private ClienteFinalMgr cfmgr;
    private ReservasEntrantesController cre;
    private JavaFXTools tools = new JavaFXTools();


    public CustomListCellReservasEntrantes(ClienteFinalMgr cfmgr, ReservasEntrantesController cre, ReservaMgr reservaMgr) {
        super();
        this.cre = cre;
        this.cfmgr = cfmgr;
        this.reservaMgr = reservaMgr;
        cantidadClientes = new Text();
        hora = new Text();
        client = new Text();
        client.setFont(Font.font("System", FontWeight.BOLD, 20.0));

        confirmar = new Button();
        confirmar.setText("Confirmar"); //Poner visto de wsp y color verde
        negar = new Button();
        negar.setText("Rechazar"); //Poner cruz y color rojo



        VBox vBoxMID = new VBox(client, hora, cantidadClientes);
        VBox vBoxBotones = new VBox(confirmar, negar);
        vBoxMID.setSpacing(5);
        vBoxBotones.setSpacing(5);

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

            confirmar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    item.setConfirmada(true);
                    reservaMgr.update(item);
                    cre.displayReservas(event);
                    tools.showAlert("Reserva confirmada", "La reserva se realizo con exito! Confirme la asistencia en Estado Reserva.");
                }
            });

            negar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Integer miId = item.getId();
                    Reserva miRes = reservaMgr.getReservaById(miId);

                    miRes.setConfirmada(false);
                    miRes.setFinalizada(true);
                    reservaMgr.update(item);
                    cre.displayReservas(event);
                    tools.showAlert("Reserva rechazada", "La reserva se rechazo con exito!");
                }
            });


        } else {
            setGraphic(null);
        }
    }
}