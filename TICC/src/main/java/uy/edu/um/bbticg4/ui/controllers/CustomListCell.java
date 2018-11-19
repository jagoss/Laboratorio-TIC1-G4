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
import uy.edu.um.bbticg4.ui.tools.JavaFXTools;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class CustomListCell extends ListCell<Restaurant> {
    private BorderPane content;
    private Text nombreFantasia;
    private Text direccion;
    private Text rating;
    private Text precioPromedio;
    private Text tipoComida;
    private Text horario;
    private Text descripcion;
    private Button reservar;
    @Autowired
    private ReservaMgr resMgr;
    @Autowired
    private RestaurantMgr restoMgr;

    private ClienteFinal cf;
    private Restaurant resto;

    private JavaFXTools tools = new JavaFXTools();
    private VBox datosReserva;
    private TextField hora;
    private Label pregunta;

    private Spinner<Double> mesSpinner = new Spinner<>();
    private Spinner<Double> diaSpinner = new Spinner<>();
    private Spinner<Double> horaSpinner = new Spinner<>();
    private Spinner<Double> minutosSpinner = new Spinner<>();
    private Spinner<Double> ocupantesSpinner = new Spinner<>();




    public CustomListCell(ClienteFinal cf, RestaurantMgr restoMgr, ReservaMgr resMgr) {
        super();

            SpinnerValueFactory mesSpinnerSVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,30,10);
            SpinnerValueFactory diaSpinnerSVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,30,10);
            SpinnerValueFactory horaSpinnerSVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,30,10);
            SpinnerValueFactory minutosSpinnerSVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,30,10);
            SpinnerValueFactory ocupantesSpinnerSVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,30,10);

            this.mesSpinner.setValueFactory(mesSpinnerSVF);
            this.diaSpinner.setValueFactory(diaSpinnerSVF);
            this.horaSpinner.setValueFactory(horaSpinnerSVF);
            this.minutosSpinner.setValueFactory(minutosSpinnerSVF);
            this.ocupantesSpinner.setValueFactory(ocupantesSpinnerSVF);



        this.cf = cf;
        this.resto = resto;
        nombreFantasia = new Text();
        nombreFantasia.setFont(Font.font("System", FontWeight.BOLD, 20.0));
        rating = new Text();
        rating.setFont(new Font(15.0));

        direccion = new Text();
        precioPromedio = new Text();
        tipoComida = new Text();

        horario = new Text();

        descripcion = new Text();

        reservar = new Button();
        reservar.setText("Reservar");
        Label mes = new Label("Seleccione el mes");
        Label dia= new Label("Seleccione el día");
        Label hora = new Label("Seleccione la hora?");
        Label minutos = new Label("Seleccione los minutos");
        Label ocupantes = new Label("Seleccione la cantidad de gente");



        VBox datosReserva = new VBox( mes, mesSpinner, dia, diaSpinner, hora, horaSpinner, minutos, minutosSpinner, ocupantes, ocupantesSpinner, reservar);



        HBox hBoxBOT = new HBox(horario);

        hBoxBOT.setSpacing(5.0);

        GridPane grid = new GridPane();
        grid.setVgap(15);
        grid.setHgap(40);
        grid.setPadding(new Insets(10,10,10,10));

        grid.add(nombreFantasia, 0 ,0, 1,1);
        grid.add(rating, 2, 0, 1,1);
        grid.add(direccion, 0,1,1,1);
        grid.add(tipoComida,1,1,1,1);
        grid.add(precioPromedio,2,1,1,1);
        grid.add(hBoxBOT,0,3,3,1);
        grid.add(descripcion,0,2,3,1);
        grid.setAlignment(Pos.CENTER);


        reservar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,FormatStyle.SHORT);
                Integer datoAno = LocalDateTime.now().getYear();
                Double datoMes = mesSpinner.getValue();
                Double datoDia = diaSpinner.getValue();
                Double datoHora = horaSpinner.getValue();
                Double datoMinutos = minutosSpinner.getValue();
                Double datoOcupantes = ocupantesSpinner.getValue();

                LocalDateTime date = LocalDateTime.of(datoAno.intValue(), datoMes.intValue(), datoDia.intValue(), datoHora.intValue(), datoMinutos.intValue());
                date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));


                Text textOcupantes = new Text(datoOcupantes.toString());

                try {
                    resto = restoMgr.getRestaurantByDireccion(direccion.getText());
                    resMgr.generarReserva(cf, resto, ocupantesSpinner.getValue(), date);

                    tools.showAlert("Reserva realizada!", "Una notificación ha sido enviada. Aguarde la confirmación del restaurant.");
                } catch (InvalidInformation invalidInformation) {
                    invalidInformation.printStackTrace();
                }


            }
        });

        content = new BorderPane();
        content.setLeft(new Label("[Graphic]"));
        content.setCenter(grid);
        content.setRight(datosReserva);
        content.setPadding(new Insets(8,8,8,8));

    }

    @Override
    protected void updateItem(Restaurant item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) { // <== test for null item and empty parameter
            nombreFantasia.setText(item.getNombreFantasia());
            direccion.setText(item.getDireccion());
            rating.setText(Integer.toString(item.getRating()) + " Estrellas");

            precioPromedio.setText(item.getCostoPersona());

            horario.setText(item.getHorario());
            descripcion.setText(item.getDescripcion());
            String comidas = item.getListaCategoriaComida().get(0).getNombre();
            for (int x = 1; x < item.getListaCategoriaComida().size(); x++){

                comidas = comidas + ", " + item.getListaCategoriaComida().get(x).getNombre();
            }

            tipoComida.setText(comidas);
            setGraphic(content);


        } else {
            setGraphic(null);
        }
    }
}
