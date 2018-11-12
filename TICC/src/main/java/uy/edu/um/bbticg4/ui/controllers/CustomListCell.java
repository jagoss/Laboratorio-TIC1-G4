package uy.edu.um.bbticg4.ui.controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import sun.plugin.javascript.navig.Anchor;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.io.IOException;

@Component
public class CustomListCell extends ListCell<Restaurant> {
        private BorderPane content;
        private Text nombreFantasia;
        private Text direccion;
        private Text rating;
        private Text precioPromedio;
        private Text tipoComida;
        private Text horario;
        private Text descripcion;
        private Button reservar;
        private AnchorPane ancla;

        private VBox datosReserva;
        private TextField hora;
        private Label pregunta;
        private Spinner<Integer> ocupantes;


        public CustomListCell() {
            super();

            nombreFantasia = new Text();
            nombreFantasia.setFont(Font.font("System", FontWeight.BOLD, 20.0));
            rating = new Text();
            rating.setFont(new Font(15.0));

            direccion = new Text();
            precioPromedio = new Text();
            tipoComida = new Text();

            horario = new Text();

            descripcion = new Text();

            reservar = new Button();
            reservar.setText("Reservar");
            Label pregunta = new Label("Cuantos van a ir?");
            TextField hora = new TextField();
            hora.setPromptText("Hora a reservar");
            Spinner<Integer> ocupantes = new Spinner<Integer>(1,15,1,1);

            VBox datosReserva = new VBox(hora, pregunta, ocupantes, reservar);
            datosReserva.setSpacing(10);
            datosReserva.setVgrow(hora, Priority.ALWAYS);



            HBox hBoxBOT = new HBox(horario);

            hBoxBOT.setSpacing(5.0);

            GridPane grid = new GridPane();
            grid.setVgap(15);
            grid.setHgap(40);
            grid.setPadding(new Insets(10,10,10,10));

            grid.add(nombreFantasia, 0 ,0, 1,1);
            grid.add(rating, 2, 0, 1,1);
            grid.add(direccion, 0,1,1,1);
            grid.add(tipoComida,1,1,1,1);
            grid.add(precioPromedio,2,1,1,1);
            grid.add(hBoxBOT,0,3,3,1);
            grid.add(descripcion,0,2,3,1);
            grid.setAlignment(Pos.CENTER_LEFT);

            AnchorPane ancla = new AnchorPane(grid);
            ancla.setTopAnchor(grid,5.0);
            ancla.setRightAnchor(grid,5.0);
            ancla.setLeftAnchor(grid,5.0);
            ancla.setBottomAnchor(grid,5.0);

            reservar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {



                }
            });


            content = new BorderPane();
            content.setLeft(new Label("[Graphic]"));
            content.setCenter(ancla);
            content.setRight(datosReserva);
            content.setPadding(new Insets(8,8,8,8));

        }

        @Override
        protected void updateItem(Restaurant item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) { // <== test for null item and empty parameter
                nombreFantasia.setText(item.getNombreFantasia());
                direccion.setText(item.getDireccion());
                rating.setText(Integer.toString(item.getRating()) + " Estrellas");

                precioPromedio.setText(item.getCostoPersona());

                horario.setText(item.getHorario());
                descripcion.setText(item.getDescripcion());
                String comidas = item.getListaCategoriaComida().get(0).getNombre();
                for (int x = 1; x < item.getListaCategoriaComida().size(); x++){

                    comidas = comidas + ", " + item.getListaCategoriaComida().get(x).getNombre();
                }

                tipoComida.setText(comidas);
                setGraphic(content);


            } else {
                setGraphic(null);
            }
        }
    }
