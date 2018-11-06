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

        HBox headline = new HBox(new Label("Reserva de"),mesa, new Label("mesa por:"), client);

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


        content = new HBox(grid);
        content.setSpacing(40);
        content.setPadding(new Insets(8,8,8,8));

    }

    @Override
    protected void updateItem(Reserva item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null && !empty) { /* <== test for null item and empty parameter
                    GET DE LA HORA
                    GET DE LA MESA
                    GET DEL CLIENTE*/

            setGraphic(content);

        } else {
            setGraphic(null);
        }
    }


}