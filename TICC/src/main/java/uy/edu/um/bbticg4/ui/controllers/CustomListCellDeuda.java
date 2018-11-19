/*
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

import javafx.scene.layout.BorderPane;
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
import uy.edu.um.bbticg4.exceptions.InvalidInformation;
import uy.edu.um.bbticg4.service.ClienteFinalMgr;
import uy.edu.um.bbticg4.service.ReservaMgr;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.bbticg4.service.entities.ClienteFinal;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.math.BigDecimal;

public class CustomListCell extends ListCell<Restaurant> {

private BorderPane content;
private Text nombreFantasia;
private Text nombre;
private Text email;
private Text celular;
private Text deuda;
private Button actualizar;
private Text direccion;
private TextField actualizacion;

@Autowired
private RestaurantMgr restoMgr;

private Restaurant resto;

        this.resto = resto;
        nombreFantasia = new Text();
        nombreFantasia.setFont(Font.font("System", FontWeight.BOLD, 20.0));
        nombre = new Text();
        nombre.setFont(new Font(15.0));
        email = new Text();
        celular = new Text();
        deuda = new Text();
        direccion = new Text();

        actualizacion = new TextField();
        valor = new BigDecimal(value: actualizacion.getText);


        actualizar = new Button();
        actualizar.setText("Actualizar");

        HBox hBoxBOT = new HBox(horario);

        GridPane grid = new GridPane();
        grid.setVgap(15);
        grid.setHgap(40);
        grid.setPadding(new Insets(10,10,10,10));

        grid.add(nombreFantasia,0,0,1,1);
        grid.add(nombre,2,0,1,1);
        grid.add(direccion,0,1,1,1);
        grid.add(email,0,1,1,1);
        grid.add(celular,1,1,1,1);
        grid.add(actualizacion,1,1,1,1);
        grid.add(deuda,2,1,1,1);
        grid.setAlignment(Pos.CENTER);


        actualizar.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent event) {

        try {
        resto = restoMgr.getRestaurantByDireccion(direccion.getText());
        } catch (InvalidInformation invalidInformation) {
        invalidInformation.printStackTrace();
        }

        resto.setDeuda(resto.getDeuda().substract(valor));

        });
}

@Override
protected void updateItem(Restaurant item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) { // <== test for null item and empty parameter
        nombreFantasia.setText(item.getNombreFantasia());
        direccion.setText(item.getDireccion());
        nombre.setText(item.getNombre);
        email.setText(item.getEmail);
        celular.setText(item.getCelular);
        deuda.setText(item.getDeuda);


        } else {
        setGraphic(null);
        }
        }
}
