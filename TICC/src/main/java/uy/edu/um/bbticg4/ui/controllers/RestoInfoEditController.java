package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.bbticg4.service.TipoComidaMgr;
import uy.edu.um.bbticg4.service.entities.Mesa;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.ui.tools.JavaFXTools;

import java.io.IOException;
import java.util.ArrayList;
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
    private Spinner<Double> mesa2Spinner;
    @FXML
    private Spinner<Double> mesa4Spinner;
    @FXML
    private Spinner<Double> mesa6Spinner;
    @FXML
    private Spinner<Double> mesa8Spinner;

    @FXML
    public void initialize(){
        SpinnerValueFactory mesas2SVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,30,10);
        SpinnerValueFactory mesas4SVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,30,10);
        SpinnerValueFactory mesas6SVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,30,10);
        SpinnerValueFactory mesas8SVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,30,10);
        this.mesa2Spinner.setValueFactory(mesas2SVF);
        this.mesa4Spinner.setValueFactory(mesas4SVF);
        this.mesa6Spinner.setValueFactory(mesas6SVF);
        this.mesa8Spinner.setValueFactory(mesas8SVF);
    }

    @FXML
    void cancelation(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        if(resto.getFistLogin()) {

            fxmlLoader.setLocation(LogInController.class.
                    getResource("LogIn.fxml"));

            Parent root = fxmlLoader.load(
                    RestoInfoEditController.class.getResourceAsStream("LogIn.fxml"));

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

            Stage stage2 = new Stage();
            Scene sceneLogIn = new Scene(root);
            sceneLogIn.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
            stage2.setScene(sceneLogIn);
            stage2.setResizable(false);
            stage2.show();

        }else{
            fxmlLoader.setLocation(MenuInicioRestoController.class.
                    getResource("MenuInicialResto.fxml"));

            MenuInicioRestoController controller = Main.getContext().
                    getBean(MenuInicioRestoController.class);

            controller.setResto(resto);

            Parent root = fxmlLoader.load(
                    RestoInfoEditController.class.getResourceAsStream("MenuInicialResto.fxml"));

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

            Stage stage2 = new Stage();
            Scene sceneMenuInicial = new Scene(root);
            sceneMenuInicial.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pantallaPrincipalResto.css");
            stage2.setScene(sceneMenuInicial);
            stage2.setResizable(false);
            stage2.show();
        }



    }

    @FXML
    void confimation(ActionEvent event) throws IOException {

        if ((descField.getText() == null || descField.getText().equals("") ||
                ScheduleField.getText() == null || ScheduleField.getText().equals("") ||
                paymentOptions.getText() == null || paymentOptions.getText().equals("") ||
                personCost.getText() == null || personCost.getText().equals("")) && resto.getFistLogin()) {
            tools.showAlert(
                    "Datos faltantes!",
                    "No se ingresaron los datos necesarios para completar el ingreso.");

        } else {
            if(personCost != null && !personCost.getText().equals("")) {
                resto.setCostoPersona(personCost.getText()); }

            if(paymentOptions != null&& !paymentOptions.getText().equals("")){
                resto.setOpcionesDePago(paymentOptions.getText());}

            if(menuField != null && !menuField.getText().equals("")){
                resto.setMenu(menuField.getText());}

            if(descField != null && !descField.getText().equals("")){
                resto.setDescripcion(descField.getText());}

            if(ScheduleField != null && !ScheduleField.getText().equals("")){
                resto.setHorario(ScheduleField.getText());}

            List<Integer> listaCategoriaComida = new ArrayList<>();
            Double mesas2 = mesa2Spinner.getValue();
            Double mesas4 = mesa4Spinner.getValue();
            Double mesas6 = mesa6Spinner.getValue();
            Double mesas8 = mesa8Spinner.getValue();
            List<Mesa> mesasResto = new ArrayList<>();

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

            if(listaCategoriaComida.size()>0){resto.setListaCategoriaComida(foodtype.getListaPorId(listaCategoriaComida));}

            if(resto.getFistLogin()) {
                for (int x = 1; x < mesas2; x++) {
                    mesasResto.add(new Mesa(2));
                }
                for (int x = 1; x < mesas4; x++) {
                    mesasResto.add(new Mesa(4));
                }
                for (int x = 1; x < mesas6; x++) {
                    mesasResto.add(new Mesa(6));
                }
                for (int x = 1; x < mesas8; x++) {
                    mesasResto.add(new Mesa(8));
                }
            } else {

                //ACA TIENE QUE VERIFICAR SI HAY MESAS OCUPADAS
            }

            resto.setMesasTotales(mesasResto);

            resto.setFirstLogin(false);

            restoMgr.updateResto(resto);

            tools.showAlert(
                    "Datos actualizados!",
                    "Los datos se han modificado correctamente.");

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
            Scene sceneMenuInicial = new Scene(root);
            sceneMenuInicial.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pantallaPrincipalResto.css");
            stage2.setScene(sceneMenuInicial);

            stage2.setResizable(false);
            stage2.show();


        }
    }

    //falta incluir excepciones.

    public Restaurant getResto(){return resto;}

    public void setResto(Restaurant resto){this.resto = resto;}
}
