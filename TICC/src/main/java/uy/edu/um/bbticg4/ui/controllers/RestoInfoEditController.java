package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.bbticg4.service.TipoComidaMgr;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.ui.tools.JavaFXTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class RestoInfoEditController {

    @Autowired
    private JavaFXTools tools;

    @Autowired
    private RestaurantMgr restoMgr;

    @Autowired
    private TipoComidaMgr foodtype;

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
    private RadioButton cafe;

    @FXML
    private RadioButton celiaco;

    @FXML
    private RadioButton chivito;

    @FXML
    private RadioButton arabe;

    @FXML
    private RadioButton china;

    @FXML
    private RadioButton empanadas;

    @FXML
    private RadioButton ensaldas;

    @FXML
    private RadioButton burgers;

    @FXML
    private RadioButton milangas;

    @FXML
    private RadioButton parrilla;

    @FXML
    private RadioButton pasta;

    @FXML
    private RadioButton pescado;

    @FXML
    private RadioButton pizza;

    @FXML
    private RadioButton mexican;

    @FXML
    private RadioButton sushi;

    @FXML
    private RadioButton another;

    @FXML
    void cancelation(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        fxmlLoader.setLocation(MenuInicioRestoController.class.
                getResource("MenuInicialResto.fxml"));

        MenuInicioRestoController controller = Main.getContext().
                getBean(MenuInicioRestoController.class);

        controller.setResto(resto);

        Parent root = fxmlLoader.load(
                RestoInfoEditController.class.getResourceAsStream("MenuInicialResto.fxml"));

        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        Stage stage2 = new Stage();
        stage2.setScene(new Scene(root));
        stage2.setResizable(false);
        stage2.show();

    }

    @FXML
    void confimation(ActionEvent event) {

        if (descField.getText() == null || descField.getText().equals("") ||
                ScheduleField.getText() == null || ScheduleField.getText().equals("") ||
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
            List<Integer> listaCategoriaComida = new ArrayList<>();

            if(cafe.isSelected())
                listaCategoriaComida.add(9);
            if(celiaco.isSelected())
                listaCategoriaComida.add(8);
            if(chivito.isSelected())
                listaCategoriaComida.add(6);
            if(arabe.isSelected())
                listaCategoriaComida.add(4);
            if(china.isSelected())
                listaCategoriaComida.add(7);
            if(empanadas.isSelected())
                listaCategoriaComida.add(5);
            if(ensaldas.isSelected())
                listaCategoriaComida.add(10);
            if(burgers.isSelected())
                listaCategoriaComida.add(11);
            if(milangas.isSelected())
                listaCategoriaComida.add(12);
            if(parrilla.isSelected())
                listaCategoriaComida.add(1);
            if(pasta.isSelected())
                listaCategoriaComida.add(2);
            if(pescado.isSelected())
                listaCategoriaComida.add(13);
            if(pizza.isSelected())
                listaCategoriaComida.add(3);
            if(mexican.isSelected())
                listaCategoriaComida.add(14);
            if(sushi.isSelected())
                listaCategoriaComida.add(15);
            if(another.isSelected())
                listaCategoriaComida.add(16);

            resto.setListaCategoriaComida(foodtype.getListaPorId(listaCategoriaComida));

            resto.setOpcionesDePago(opcionesPago);
            resto.setHorario(horario);
            resto.setDescripcion(descripcion);
            resto.setCostoPersona(costoPersona);

            resto.setFirstLogin(false);

            restoMgr.updateResto(resto);

            tools.showAlert(
                    "Datos actualizados!",
                    "Los datos se han modificado correctamente.");
        }
    }

    //falta incluir excepciones.

    public Restaurant getResto(){return resto;}

    public void setResto(Restaurant resto){this.resto = resto;}
}
