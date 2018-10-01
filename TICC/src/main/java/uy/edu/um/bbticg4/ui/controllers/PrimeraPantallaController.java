package uy.edu.um.bbticg4.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uy.edu.um.bbticg4.exceptions.TipoComidaException;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.bbticg4.service.entities.TipoComida;

import java.util.List;

@Controller
public class PrimeraPantallaController {


    @Autowired
    private RestaurantMgr restoMgr;

    List<Restaurant> restoPorBarrio;
    List<Restaurant> listaFinal;



    @FXML
    private TableView FilteredRestaurants;
    @FXML
    private TableColumn ColumnaNombres;
    @FXML
    private TableColumn ColumnaBarrio;
    @FXML
    private TableColumn ColumnaRating;
    @FXML
    private TableColumn ColumnaTelefono;
    @FXML
    private TableColumn ColumnaEmail;

    private List<Integer> listTipoComida;

    @FXML
    private CheckBox checkParrilla;
    @FXML
    private CheckBox checkPizza;
    @FXML
    private CheckBox checkPasta;


    private Integer estrellas = 0;
    @FXML
    private CheckBox check1Star;
    @FXML
    private CheckBox check2Stars;
    @FXML
    private CheckBox check3Stars;
    @FXML
    private CheckBox check4Stars;
    @FXML
    private CheckBox check5Stars;


    private String barrio = null;
    @FXML
    private CheckBox checkPocitos;
    @FXML
    private CheckBox checkBuceo;
    @FXML
    private CheckBox checkMalvinNorte;

    @FXML
    private Button buttonSearch;

    @FXML
    void filteredByRestaurant(ActionEvent event) throws TipoComidaException {

        if (check1Star.isSelected()) {
            estrellas = 1;
        } else if (check2Stars.isSelected()) {
            estrellas = 2;
        } else if (check3Stars.isSelected()) {
            estrellas = 3;
        } else if (check4Stars.isSelected()) {
            estrellas = 4;
        } else if (check5Stars.isSelected()) {
            estrellas = 5;
        }

        if (checkParrilla.isSelected()) {
            listTipoComida.add(1);
        }
        if (checkPasta.isSelected()) {
            listTipoComida.add(2);
        }
        if (checkPizza.isSelected()) {
            listTipoComida.add(3);
        }


        if (checkPocitos.isSelected()) {
            barrio = "Pocitos";
        } else if (checkBuceo.isSelected()) {
            barrio = "Buceo";
        } else if (checkMalvinNorte.isSelected()) {
            barrio = "MalvinNorte";  //ACORDARSE QUE NO LLEVA ESPACIO
        }

        if( (listTipoComida != null || listTipoComida.isEmpty()) && estrellas.equals(0)){
            restoPorBarrio = restoMgr.filtrarRestosPorBarrio(barrio);
        } else if(estrellas.equals(0)){
            restoPorBarrio = restoMgr.filtrarRestosPorBarrioYTipoComida(listTipoComida, barrio);
        } else{
            restoPorBarrio = restoMgr.filtrarRestosPorBarrioYTipoComidaYRating(listTipoComida, estrellas, barrio);
        }

        ObservableList<Restaurant> resultados = FXCollections.observableArrayList();

        for(int i = 0; i<restoPorBarrio.size(); i++){
            resultados.add(restoPorBarrio.get(i));
        }

        ColumnaNombres.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("name"));
        ColumnaBarrio.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("barrio"));
        ColumnaRating.setCellValueFactory(new PropertyValueFactory<Restaurant,Integer>("rating"));
        ColumnaTelefono.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("cellphone"));
        ColumnaEmail.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("email"));

        FilteredRestaurants.setItems(resultados);

        listTipoComida.clear();
        estrellas = 0;

    }


}
