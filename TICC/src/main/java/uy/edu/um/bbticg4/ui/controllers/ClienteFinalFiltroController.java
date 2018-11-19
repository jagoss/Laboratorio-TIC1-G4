package uy.edu.um.bbticg4.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.exceptions.TipoComidaException;
import uy.edu.um.bbticg4.service.BarrioMgr;
import uy.edu.um.bbticg4.service.ReservaMgr;
import uy.edu.um.bbticg4.service.entities.Barrio;
import uy.edu.um.bbticg4.service.entities.ClienteFinal;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.service.RestaurantMgr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ClienteFinalFiltroController {

    @Autowired
    private RestaurantMgr restoMgr;

    @Autowired
    private ReservaMgr resMgr;

    @Autowired
    private BarrioMgr barrioMgr;

    private ClienteFinal cf;

    List<Restaurant> restoPorBarrio = new LinkedList<>();
    List<Barrio> filtroBarrio = new LinkedList<>();
    private List<Integer> listTipoComida = new ArrayList<Integer>(20);
    private Integer rating = 0;

    @FXML
    private TableView FilteredRestaurants;
    @FXML
    private ListView<Restaurant> listaRestaurantes;
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
    private CheckBox checkSushi;

    @FXML
    private CheckBox checkMejicana;

    @FXML
    private CheckBox checkPescado;

    @FXML
    private CheckBox checkMilanesas;

    @FXML
    private CheckBox checkHamburguesas;

    @FXML
    private CheckBox checkArabe;

    @FXML
    private CheckBox checkEmpanadas;

    @FXML
    private CheckBox checkChivito;

    @FXML
    private CheckBox checkChina;

    @FXML
    private CheckBox checkCeliaco;

    @FXML
    private CheckBox checkCafe;

    @FXML
    private CheckBox checkEnsaladas;

    @FXML
    private CheckBox checkOtros;



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
    private CheckBox checkAguada;

    @FXML
    private CheckBox checkBarrioSur;

    @FXML
    private CheckBox checkPenarol;

    @FXML
    private CheckBox checkPuntaGorda;

    @FXML
    private CheckBox checkMaronas;

    @FXML
    private CheckBox checkParqueRodo;

    @FXML
    private CheckBox checkCordon;

    @FXML
    private CheckBox checkCerro;

    @FXML
    private CheckBox checkCentro;

    @FXML
    private CheckBox checkCarrasco;


    @FXML
    private Button buttonSearch;


    @FXML
    void filteredConLista(ActionEvent event) throws TipoComidaException {

        ObservableList<Restaurant> resultados = FXCollections.observableArrayList();
        for (int i = 0; i < restoPorBarrio.size(); i++) {
            resultados.clear();
        }
        listaRestaurantes.setItems(resultados);

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

        if (checkParrilla.isSelected()) {
            listTipoComida.add(1);
        }
        if (checkPasta.isSelected()) {
            listTipoComida.add(2);
        }
        if (checkPizza.isSelected()) {
            listTipoComida.add(3);
        }
        if (checkSushi.isSelected()) {
            listTipoComida.add(15);
        }
        if (checkMejicana.isSelected()) {
            listTipoComida.add(14);
        }
        if (checkPescado.isSelected()) {
            listTipoComida.add(13);
        }

        if (checkMilanesas.isSelected()) {
            listTipoComida.add(12);
        }
        if (checkHamburguesas.isSelected()) {
            listTipoComida.add(11);
        }
        if (checkArabe.isSelected()) {
            listTipoComida.add(4);
        }

        if (checkEmpanadas.isSelected()) {
            listTipoComida.add(5);
        }
        if (checkChivito.isSelected()) {
            listTipoComida.add(6);
        }
        if (checkChina.isSelected()) {
            listTipoComida.add(7);
        }

        if (checkCeliaco.isSelected()) {
            listTipoComida.add(8);
        }
        if (checkCafe.isSelected()) {
            listTipoComida.add(9);
        }
        if (checkEnsaladas.isSelected()) {
            listTipoComida.add(10);
        }
        if (checkOtros.isSelected()) {
            listTipoComida.add(16);
        }





        if (checkPocitos.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Pocitos"));
        }
        if (checkBuceo.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Buceo"));
        }
        if (checkMalvinNorte.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("MalvinNorte"));
        }


        if (checkAguada.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Aguada"));
        }
        if (checkBarrioSur.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Barrio Sur"));
        }
        if (checkPenarol.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Peñarol"));
        }
        if (checkPuntaGorda.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Punta Gorda"));
        }
        if (checkMaronas.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Maroñas"));
        }
        if (checkParqueRodo.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Parque Rodo"));
        }
        if (checkCordon.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Cordon"));
        }
        if (checkCerro.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Cerro"));
        }
        if (checkCentro.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Centro"));
        }
        if (checkCarrasco.isSelected()) {
            filtroBarrio.add(barrioMgr.getBarrio("Carrasco"));
        }







        if ((listTipoComida == null || listTipoComida.isEmpty()) && rating.equals(0)) {
            restoPorBarrio = restoMgr.filtrarRestosPorBarrio(filtroBarrio);
        } else if (rating.equals(0)) {
            restoPorBarrio = restoMgr.filtrarRestosPorBarrioYTipoComida(listTipoComida, filtroBarrio);
        } else {
            restoPorBarrio = restoMgr.filtrarRestosPorBarrioYTipoComidaYRating(listTipoComida, rating, filtroBarrio);
        }



        for (int i = 0; i < restoPorBarrio.size(); i++) {
            resultados.add(restoPorBarrio.get(i));
        }
        listaRestaurantes.setItems(resultados);

        listaRestaurantes.setCellFactory(new Callback<ListView<Restaurant>, ListCell<Restaurant>>() {
            @Override
            public ListCell<Restaurant> call(ListView<Restaurant> listView) {
                return new CustomListCell(cf, restoMgr, resMgr);
            }
        });

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(ClienteFinalFiltroController.class.getResourceAsStream("InicioApp.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    public ClienteFinal getCf() {
        return cf;
    }

    public void setCf(ClienteFinal cf) {
        this.cf = cf;
    }
}



