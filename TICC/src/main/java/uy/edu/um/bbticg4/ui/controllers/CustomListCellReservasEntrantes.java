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

/*
                mesa.setText("LA MESA");
                hora.setText("LA HORA");
                client.setText("EL CLIENT");
                setGraphic(content);
*/
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

   /* private BorderPane borderContent;
    private HBox content;
    private HBox headline;
    private Text mesa;
    private Text hora;
    private Text client;

    private Button confirmar;
    private Button negar;


    @Autowired
    private ReservasEntrantesController cre;


    public CustomListCellReservasEntrantes() {
        super();

        mesa = new Text();
        client = new Text();
        hora = new Text();

        confirmar = new Button();
        confirmar.setText("Confirmar"); //Poner visto de wsp y color verde
        negar = new Button();
        negar.setText("Rechazar"); //Poner cruz y color rojo

        Label mesaPor = new Label("mesa por:");
        Label reservaDe = new Label("Reserva de");
*//*        confirmar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            cre.displayReservas(event);

            }
        });*//*

        headline = new HBox(reservaDe,mesa, mesaPor, client);


        VBox confirmacionReserva = new VBox(confirmar,negar);

        headline.setSpacing(5.0);



        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setAlignment(Pos.CENTER);

        grid.add(headline,0,0,3,1);
        grid.add(hora,0,1,1,1);
        grid.add(confirmar,1,1,1,1);
        grid.add(negar,2,1,1,1);



        borderContent = new BorderPane();
        borderContent.setLeft(new Label("[Foto_Perfil]"));
        borderContent.setCenter(grid);
        borderContent.setRight(confirmacionReserva);
        borderContent.setPadding(new Insets(8,8,8,8));
    }

    @Override
    protected void updateItem(Reserva item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null && !empty) { // <== test for null item and empty parameter

            //hora.setText();
            client.setText(item.getCf().getFirstName() +" " + item.getCf().getLastName());

            mesa.setText(*//*item.getResto().getMesasTotales()*//* "MESA");
            hora.setText(*//*item.getResto().getMesasTotales()*//* "HORA");
            client.setText(*//*item.getResto().getMesasTotales()*//* "CLIENT");



            setGraphic(content);

        } else {
            setGraphic(null);
        }
    }


}
*/