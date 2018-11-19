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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.ReservaMgr;
import uy.edu.um.bbticg4.service.RestaurantMgr;
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

import java.math.BigDecimal;
import java.time.LocalDate;

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

    public CustomListCellEstadoReservas(EstadoReservasController erc, ClienteFinalMgr cfmgr, ReservaMgr reservaMgr,
    RestaurantMgr rm) {

        super();
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

        /*
        asistio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                cre.displayReservas(event);

            }
        });

        noAsistio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                cre.displayReservas(event);

            }
        });*/

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
            client.setText(item.getCf().getFirstName() +" " + item.getCf().getLastName());

            setGraphic(content);

            asistio.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    item.setAsistio(true);
                    item.setFinalizada(true);
                    erc.refresh(event);
                    reservaMgr.update(item);
                    item.getResto().setDeuda(
                            item.getResto().getDeuda().add(new BigDecimal(100.00)));
                    rm.updateResto(item.getResto());


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
