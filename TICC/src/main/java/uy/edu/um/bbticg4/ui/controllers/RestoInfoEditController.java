package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.ui.tools.JavaFXTools;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestoInfoEditController {

    @Autowired
    private JavaFXTools tools;

    private Restaurant resto;
    @FXML
    private TextArea descField;

    @FXML
    private Button gobackButton;

    @FXML
    private Button ConfirmButton;

    @FXML
    private TextArea ScheduleField;

    @FXML
    private TextArea foodOptions;

    @FXML
    private TextArea menuField;

    @FXML
    private TextField paymentOptions;

    @FXML
    private TextField personCost;

    @FXML
    void cancelation(ActionEvent event) {

        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void confimation(ActionEvent event) {

        if (descField.getText() == null || descField.getText().equals("") ||
                ScheduleField.getText() == null || ScheduleField.getText().equals("") ||
                foodOptions.getText() == null || foodOptions.getText().equals("") ||
                paymentOptions.getText() == null || paymentOptions.getText().equals("") ||
                personCost.getText() == null || personCost.getText().equals(""))
                {

                        tools.showAlert(
                                "Datos faltantes!",
                                "No se ingresaron los datos necesarios para completar el ingreso.");

        } else {

            String costoPersona = personCost.getText();
            String opcionesPago = paymentOptions.getText();
            String menu = menuField.getText();
            String descripcion = descField.getText();
            String horario = ScheduleField.getText();
            List<String> listaCategoriaComida = new ArrayList(String.split(",")); //buscar forma de convertir en lista de tipos de comida


            //falta guardar el restaurante logeado en una variable "Restaurant" para operar con el
            resto.setListaCategoriaComida(listaCategoriaComida);
            resto.setOpcionesDePago(opcionesPago);
            resto.setHorario(horario);
            resto.setDescripcion(descripcion);
            resto.setCostoPersona(costoPersona);
        }
    }

    //falta incluir excepciones.

}
