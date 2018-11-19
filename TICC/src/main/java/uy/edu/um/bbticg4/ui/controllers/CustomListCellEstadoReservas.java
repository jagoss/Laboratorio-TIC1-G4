package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;


import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.ReservaMgr;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;


import java.math.BigDecimal;


public class CustomListCellEstadoReservas extends ListCell<Reserva>{

    private HBox content;
    private Text cantidadClientes;
    private Text hora;
    private Text client;
    private Button asistio;
    private Button noAsistio;

    private ClienteFinalMgr cfmgr;
    private RestaurantMgr rm;
    private EstadoReservasController erc;
    private ReservaMgr reservaMgr;
    private Restaurant resto;

    public CustomListCellEstadoReservas(EstadoReservasController erc, ClienteFinalMgr cfmgr, ReservaMgr reservaMgr,
                                        RestaurantMgr rm, Restaurant resto) {

        super();
        this.resto = resto;
        this.erc = erc;
        this.rm = rm;
        this.reservaMgr = reservaMgr;
        this.cfmgr = cfmgr;
        cantidadClientes = new Text();
        hora = new Text();
        client = new Text();
        client.setFont(Font.font("System", FontWeight.BOLD, 20.0));

        asistio = new Button();
        asistio.setText("Asistio");
        noAsistio = new Button();
        noAsistio.setText("No Asistio");



        VBox vBoxMID = new VBox(client, hora, cantidadClientes);
        VBox vBoxBotones = new VBox(asistio, noAsistio);
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

            //hora.setText();
            client.setText("Cliente: " + item.getCf().getFirstName() +" " + item.getCf().getLastName());
            hora.setText("Hora de la reserva: " + item.getHoraReserva().toString());
            cantidadClientes.setText("Cantidad de clientes: " + item.getCantidad().toString());
            setGraphic(content);

            asistio.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    item.setAsistio(true);
                    item.setFinalizada(true);
                    erc.refresh(event);
                    reservaMgr.update(item);
                    resto.setDeuda(
                            resto.getDeuda().add(new BigDecimal(100.00)));
                    rm.updateResto(resto);


                }
            });

            noAsistio.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    item.setAsistio(false);
                    item.setFinalizada(true);
                    erc.refresh(event);

                }
            });

        } else {
            setGraphic(null);
        }
    }


}