package uy.edu.um.UI.controllers;

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
import um.edu.uy.bbticg4.service.entities.Restaurant;
import um.edu.uy.bbticg4.service.RestaurantMgr;

import java.util.List;

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


    private String tipoDeComida = null;
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
    void handleFilterSearch(ActionEvent event) {

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
            tipoDeComida = "Parrilla";
        } else if (checkPasta.isSelected()) {
            tipoDeComida = "Pasta";
        } else if (checkPizza.isSelected()) {
            tipoDeComida = "Pizza";
        }


        if (checkPocitos.isSelected()) {
            barrio = "Pocitos";
        } else if (checkBuceo.isSelected()) {
            barrio = "Buceo";
        } else if (checkMalvinNorte.isSelected()) {
            barrio = "MalvinNorte";  //ACORDARSE QUE NO LLEVA ESPACIO
        }

//        if (estrellas.equals(0)) {
//            restoPorBarrio = restoMgr.filtrarRestosporBarrio(barrio);
//        } else {
//            restoPorBarrio = restoMgr.filtrarRestosporBarrio(barrio, estrellas);
//        }

        if(tipoDeComida != null){

            for(int i = 0; i<restoPorBarrio.size(); i++){
                List<String> listaCategoria = restoPorBarrio.get(i).getListaCategoriaComida();

                boolean laComidaBuscadaEsta = false;

                for(int j = 0; j<listaCategoria.size(); j++){

                    if( listaCategoria.get(j) != null && tipoDeComida.equals(listaCategoria.get(j))){
                        laComidaBuscadaEsta = true;
                    }
                }

                if(laComidaBuscadaEsta){
                  listaFinal.add(restoPorBarrio.get(i));
                }

            }
            restoPorBarrio = listaFinal;

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
        }
    }


}
