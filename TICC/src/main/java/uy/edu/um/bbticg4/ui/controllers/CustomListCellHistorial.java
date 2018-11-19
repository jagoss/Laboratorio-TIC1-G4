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

import java.time.LocalDate;

@Component
public class CustomListCellHistorial extends ListCell<Reserva>{

    private HBox content;
    private HBox headline;
    //private Text mesa;
    private Text hora;
    private Text client;
    private Text asistio;


    public CustomListCellHistorial() {
        super();

        client = new Text();
        hora = new Text();
        asistio = new Text();

        headline = new HBox(new Label("Reserva de"), client);

        headline.setSpacing(5.0);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setAlignment(Pos.CENTER);

        grid.add(headline,0,0,3,1);
        grid.add(hora,0,1,1,1);
        grid.add(asistio, 1,0,1,1);

        content = new HBox(grid);
        content.setSpacing(40);
        content.setPadding(new Insets(8,8,8,8));

    }

    @Override
    protected void updateItem(Reserva item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null && !empty) { // <== test for null item and empty parameter

            //hora.setText();
            client.setText(item.getCf().getFirstName() +" " + item.getCf().getLastName());
            if(item.isAsistio() == true){
                asistio.setText("Asistio");
            } else {
                asistio.setText("No asistio");
            }

            setGraphic(content);

        } else {
            setGraphic(null);
        }
    }


}
