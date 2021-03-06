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
import uy.edu.um.bbticg4.exceptions.InvalidUserInformation;
import uy.edu.um.bbticg4.exceptions.UserAlreadyExists;
import uy.edu.um.bbticg4.service.BarrioMgr;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.bbticg4.service.entities.Barrio;
import uy.edu.um.bbticg4.ui.tools.JavaFXTools;

import java.io.IOException;

@Component
public class AdminRegistroRestauranteController {

    @Autowired
    private Main main;

    @Autowired
    private RestaurantMgr restaurantMgr;

    @Autowired
    private BarrioMgr barrioMgr;

    @Autowired
    private JavaFXTools tools;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNombreFantasia;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtConfirmarEmail;

    @FXML
    private TextField txtRUC;

    @FXML
    private TextField txtCuentaBancaria;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtVerificarContrasena;

    @FXML
    private TextField txtDireccion;

    @FXML
    private final TextField txtBarrio = new TextField("");

    @FXML
    private MenuButton barriosDisponibles;

    @FXML
    private RadioMenuItem pocitos;

    @FXML
    private RadioMenuItem malvinNorte;

    @FXML
    private RadioMenuItem buceo;

    /*   @FXML
    private RadioMenuItem aguada;

    @FXML
    private RadioMenuItem barrioSur;

    @FXML
    private RadioMenuItem carrasco;

    @FXML
    private RadioMenuItem centro;

    @FXML
    private RadioMenuItem cerro;

    @FXML
    private RadioMenuItem cordon;

    @FXML
    private RadioMenuItem parqueRodo;

    @FXML
    private RadioMenuItem maronas;

    @FXML
    private RadioMenuItem puntaGorda;

    @FXML
    private RadioMenuItem penarol;*/


    @FXML
    private TextField txtTelefono;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAgregar;

    @FXML
    void agregarRestaurante(ActionEvent event) {
        if (txtNombre.getText() == null || txtNombre.getText().equals("") ||
                txtEmail.getText() == null || txtEmail.getText().equals("") ||
                txtConfirmarEmail.getText() == null || txtConfirmarEmail.getText().equals("") ||
                txtRUC.getText() == null || txtRUC.getText().equals("") ||
                txtCuentaBancaria.getText() == null || txtCuentaBancaria.getText().equals("") ||
                txtContrasena.getText() == null || txtContrasena.getText().equals("") ||
                txtVerificarContrasena.getText() == null || txtVerificarContrasena.getText().equals("") ||
                txtDireccion.getText() == null || txtDireccion.getText().equals("") ||
                txtBarrio.getText() == null || txtBarrio.getText().equals("") ||
                txtTelefono.getText() == null || txtTelefono.getText().equals("")) {

            tools.showAlert(
                    "Datos faltantes!",
                    "No se ingresaron los datos necesarios para completar el ingreso.");

        } else {

            try {
                Long ruc = Long.parseLong(txtRUC.getText());
                String name = txtNombre.getText();
                String nombreFantasia = txtNombreFantasia.getText();
                String contrasena = txtContrasena.getText(); //NO ES ALFANUMERICA, EDITAR LUEGO
                String email = txtEmail.getText();           //NO ES ALFANUMERICA, EDITAR LUEGO
                String telefono = txtTelefono.getText();
                String barrio = txtBarrio.getText();
                String cuentaBancaria = txtCuentaBancaria.getText();
                String direccion = txtDireccion.getText();

                try {
                    Barrio miBarrio = barrioMgr.getBarrio(barrio);
                    restaurantMgr.addRestaurant(name, nombreFantasia, contrasena, cuentaBancaria, ruc, email, telefono,
                            direccion, miBarrio);


                    tools.showAlert("Restaurante agregado", "Se agrego con exito el restaurante!");

                    cerrar(event);

                } catch (InvalidUserInformation invalidUserInformation) {
                    tools.showAlert(
                            "Informacion invalida !",
                            "Se encontro un error en los datos ingresados.");
                } catch (UserAlreadyExists userAlreadyExists) {
                    tools.showAlert(
                            "Restaurante ya registrado !",
                            "El Restaurante indicado ya ha sido registrado en el sistema).");

                } catch (IOException e) {
                    e.printStackTrace();
                }


            } catch (NumberFormatException e) {

                tools.showAlert(
                        "Datos incorrectos !",
                        "El RUC no tiene el formato esperado (numerico).");

            }

        }
    }

    @FXML
    public void selectedPocitos(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Pocitos");
        txtBarrio.setText("Pocitos");
    }
    @FXML
    public void selectedMalvinNorte(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Malvin Norte");
        txtBarrio.setText("MalvinNorte");
    }
    @FXML
    public void selectedBuceo(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Buceo");
        txtBarrio.setText("Buceo");
    }
   /* @FXML
    public void selectedAguada(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Aguada");
        txtBarrio.setText("Aguada");
    }
    @FXML
    public void selectedBarrioSur(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Barrio Sur");
        txtBarrio.setText("Barrio Sur");
    }
    @FXML
    public void selectedCarrasco(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Carrasco");
        txtBarrio.setText("Carrasco");
    }
    @FXML
    public void selectedCentro(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Centro");
        txtBarrio.setText("Centro");
    }
    @FXML
    public void selectedCerro(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Cerro");
        txtBarrio.setText("Cerro");
    }
    @FXML
    public void selectedCordon(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Cordon");
        txtBarrio.setText("Cordon");
    }
    @FXML
    public void selectedParqueRodo(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Parque Rodo");
        txtBarrio.setText("Parque Rodo");
    }
    @FXML
    public void selectedMaronas(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Maroñas");
        txtBarrio.setText("Maroñas");
    }
    @FXML
    public void selectedPuntaGorda(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Punta Gorda");
        txtBarrio.setText("Punta Gorda");
    }
    @FXML
    public void selectedPenarol(ActionEvent actionEvent) {
        selectedBarrio(actionEvent);
        barriosDisponibles.setText("Peñarol");
        txtBarrio.setText("Peñarol");
    }

    @FXML
    public void selectedBarrio(ActionEvent actionEvent) {
        ToggleGroup toggleGroup = new ToggleGroup();
        pocitos.setToggleGroup(toggleGroup);
        malvinNorte.setToggleGroup(toggleGroup);
        buceo.setToggleGroup(toggleGroup);
    }*/

    @FXML
    public void selectedBarrio(ActionEvent actionEvent) {
        ToggleGroup toggleGroup = new ToggleGroup();
        pocitos.setToggleGroup(toggleGroup);
        malvinNorte.setToggleGroup(toggleGroup);
        buceo.setToggleGroup(toggleGroup);
    }

    @FXML
    public void cerrar(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(AdminRegistroRestauranteController.class.getResourceAsStream("AdminPrincipal.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
        stage.close();
    }
}

