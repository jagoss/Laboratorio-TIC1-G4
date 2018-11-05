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
import uy.edu.um.bbticg4.service.entities.Restaurant;

@Component
public class CustomListCell extends ListCell<Restaurant> {
        private HBox content;
        private Text nombreFantasia;
        private Text direccion;
        private Text rating;
        private Text precioPromedio;
        private Text tipoComida;
        private Text horaApertura;
        private Text horaCerrado;
        private Text descripcion;
        private Button reservar;


        public CustomListCell() {
            super();

            nombreFantasia = new Text();
            nombreFantasia.setFont(Font.font("System", FontWeight.BOLD, 20.0));
            rating = new Text();
            rating.setFont(new Font(15.0));

            direccion = new Text();
            precioPromedio = new Text();
            tipoComida = new Text();

            horaApertura = new Text();
            horaCerrado = new Text();

            descripcion = new Text();

            reservar = new Button();
            reservar.setText("Reservar");


            HBox hBoxBOT = new HBox(horaApertura,new Label("-"), horaCerrado);

            hBoxBOT.setSpacing(5.0);

            GridPane grid = new GridPane();
            grid.setVgap(15);
            grid.setHgap(40);
            grid.setPadding(new Insets(10,10,10,10));

            grid.add(nombreFantasia, 0 ,0, 1,1);
            grid.add(rating, 1, 0, 1,1);
            grid.add(direccion, 0,1,1,1);
            grid.add(tipoComida,1,1,1,1);
            grid.add(precioPromedio,2,1,1,1);
            grid.add(hBoxBOT,0,3,3,1);
            grid.add(descripcion,0,2,3,1);
            grid.setAlignment(Pos.CENTER);


            content = new HBox(new Label("[Graphic]"), grid, reservar);
            content.setSpacing(40);
            content.setPadding(new Insets(8,8,8,8));

        }

        @Override
        protected void updateItem(Restaurant item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) { // <== test for null item and empty parameter
                nombreFantasia.setText(item.getNombreFantasia());
                direccion.setText(item.getDireccion());
                rating.setText("5 estrellas");

                precioPromedio.setText("$$$$$");
                tipoComida.setText("Torta Fritas");
                horaApertura.setText("3:00");
                horaCerrado.setText("7:00");
                descripcion.setText("Ameo, si kere esa torta frita ya sabe, si no, balazo. Compras o te quemo el rancho.");
                setGraphic(content);

            } else {
                setGraphic(null);
            }
        }
    }
