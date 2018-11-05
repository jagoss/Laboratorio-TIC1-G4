package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class ReservasController {

    @FXML
    private TextField hora;

    @FXML
    private MenuButton cantidadDePersonas;

    @FXML
    private MenuItem unoADos;

    @FXML
    private MenuItem dosACuatro;

    @FXML
    private MenuItem masDeCuatro;

    @FXML
    private MenuButton piso;

    @FXML
    private MenuItem primero;

    @FXML
    private MenuItem segundo;

    @FXML
    void Cancelar(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Reservar(ActionEvent event) {

    }

    @FXML
    void selectUnoADos(ActionEvent event) {
        selectedPersonas(event);
        cantidadDePersonas.setText("1 a 2");
    }

    @FXML
    void selectDosACuatro(ActionEvent event) {
        selectedPersonas(event);
        cantidadDePersonas.setText("2 a 4");
    }

    @FXML
    void selectMasDeCuatro(ActionEvent event) {
        selectedPersonas(event);
        cantidadDePersonas.setText("Mas de 4");
    }

    @FXML
    void selectPrimero(ActionEvent event) {
        selectedPiso(event);
        piso.setText("1ro");
    }

    @FXML
    void selectSegundo(ActionEvent event) {
        selectedPiso(event);
        piso.setText("2do");
    }


    @FXML
    public void selectedPersonas(ActionEvent event) {
        ToggleGroup toggleGroup = new ToggleGroup();
        unoADos.setToggleGroup(toggleGroup);
        dosACuatro.setToggleGroup(toggleGroup);
        masDeCuatro.setToggleGroup(toggleGroup);
    }

    @FXML
    public void selectedPiso(ActionEvent event) {
        ToggleGroup toggleGroup = new ToggleGroup();
        primero.setToggleGroup(toggleGroup);
        segundo.setToggleGroup(toggleGroup);
    }
}