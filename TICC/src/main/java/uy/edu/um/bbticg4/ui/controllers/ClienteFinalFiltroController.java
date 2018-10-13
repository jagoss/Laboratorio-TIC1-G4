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
import uy.edu.um.bbticg4.service.BarrioMgr;
import uy.edu.um.bbticg4.service.entities.Barrio;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.service.RestaurantMgr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ClienteFinalFiltroController {

    @Autowired
    private RestaurantMgr restoMgr;

    @Autowired
    private BarrioMgr barrioMgr;

    List<Restaurant> restoPorBarrio = new LinkedList<>();
    List<Barrio> filtroBarrio = new LinkedList<>();
    private List<Integer> listTipoComida = new ArrayList<Integer>(20);
    private Integer rating = 0;

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

    @FXML
    private CheckBox checkParrilla;
    @FXML
    private CheckBox checkPizza;
    @FXML
    private CheckBox checkPasta;

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
            rating = 1;
        } else if (check2Stars.isSelected()) {
            rating = 2;
        } else if (check3Stars.isSelected()) {
            rating = 3;
        } else if (check4Stars.isSelected()) {
            rating = 4;
        } else if (check5Stars.isSelected()) {
            rating = 5;
        }

        if (checkParrilla.isSelected()) { listTipoComida.add(1); }
        if (checkPasta.isSelected()) { listTipoComida.add(2); }
        if (checkPizza.isSelected()) { listTipoComida.add(3); }

        if (checkPocitos.isSelected()) { filtroBarrio.add(barrioMgr.getBarrio("Pocitos"));}
        if (checkBuceo.isSelected()) { filtroBarrio.add(barrioMgr.getBarrio("Buceo"));}
        if (checkMalvinNorte.isSelected()) { filtroBarrio.add(barrioMgr.getBarrio("MalvinNorte"));}

        if( (listTipoComida == null || listTipoComida.isEmpty()) && rating.equals(0)){
            restoPorBarrio = restoMgr.filtrarRestosPorBarrio(filtroBarrio);
        } else if(rating.equals(0)){
            restoPorBarrio = restoMgr.filtrarRestosPorBarrioYTipoComida(listTipoComida, filtroBarrio);
        } else{
            restoPorBarrio = restoMgr.filtrarRestosPorBarrioYTipoComidaYRating(listTipoComida, rating, filtroBarrio);
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
        filtroBarrio.clear();
        rating = 0;

    }

}
