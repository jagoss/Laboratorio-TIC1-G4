package uy.edu.um.bbticg4.ui.controllers;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import uy.edu.um.bbticg4.service.entities.Restaurant;


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


        public CustomListCell() {
            super();

            nombreFantasia = new Text();
            rating = new Text();

            direccion = new Text();
            precioPromedio = new Text();
            tipoComida = new Text();

            horaApertura = new Text();
            horaCerrado = new Text();

            descripcion = new Text();

            HBox hBoxTOP = new HBox(nombreFantasia, rating);
            HBox hBoxMID = new HBox(direccion, precioPromedio, tipoComida);;

            HBox hBoxBOT = new HBox(horaApertura, horaCerrado);
            VBox vBox = new VBox(hBoxTOP, hBoxMID, descripcion, hBoxBOT );
            vBox.setSpacing(5.0);      //ESPACIO ENTRE LAS CELDAS EN VBOX
            vBox.setPadding(new Insets(5,10,5,10)); //ESPACIO DEL VBOX CON LO QUE ESA AFUERA (MARGENES POR EJEMPLO


            content = new HBox(new Label("[Graphic]"), vBox);
            content.setSpacing(40);
            content.setPadding(new Insets(5,5,5,5));
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
                horaApertura.setText("3:00 a.m.");
                horaCerrado.setText("7:00 a.m.");
                descripcion.setText("Ameo, si kere esa torta frita ya sabe");
                setGraphic(content);
            } else {
                setGraphic(null);
            }
        }
    }
