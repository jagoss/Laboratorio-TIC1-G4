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

@Component
public class CustomListCellReservasEntrantes extends ListCell<Reserva>{

    private HBox content;
    private HBox headline;
    private Text mesa;
    private Text hora;
    private Text client;

    private Button confirmar;
    private Button negar;


    public CustomListCellReservasEntrantes() {
        super();

        mesa = new Text();
        client = new Text();
        hora = new Text();

        confirmar = new Button();
        confirmar.setText("Confirmar"); //Poner visto de wsp y color verde
        negar = new Button();
        negar.setText("Rechazar"); //Poner cruz y color rojo


    }
}
