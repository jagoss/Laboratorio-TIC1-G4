package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.MainAdmin;
import uy.edu.um.bbticg4.exceptions.InvalidUserInformation;
import uy.edu.um.bbticg4.exceptions.UserAlreadyExists;
import uy.edu.um.bbticg4.service.BarrioMgr;
import uy.edu.um.bbticg4.service.RestaurantMgr;

@Component
public class AdminRegistroRestauranteController {

    @Autowired
    private MainAdmin main;

    @Autowired
    private RestaurantMgr restaurantMgr;

    @Autowired
    private BarrioMgr barrioMgr;
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
    private TextField txtBarrio;

    @FXML
    private TextField txtTelefono;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAgregar;

    @FXML
    void agregarRestaurante(ActionEvent event) {
        if (        txtNombre.getText() == null              || txtNombre.getText().equals("")              ||
                txtEmail.getText() == null               || txtEmail.getText().equals("")               ||
                txtConfirmarEmail.getText() == null      || txtConfirmarEmail.getText().equals("")      ||
                    txtRUC.getText() == null                 || txtRUC.getText().equals("")                 ||
                txtCuentaBancaria.getText() == null      || txtCuentaBancaria.getText().equals("")      ||
                    txtContrasena.getText() == null          || txtContrasena.getText().equals("")          ||
                txtVerificarContrasena.getText() == null || txtVerificarContrasena.getText().equals("") ||
                txtDireccion.getText() == null           || txtDireccion.getText().equals("")           ||
                    txtBarrio.getText() == null              || txtBarrio.getText().equals("")              ||
                    txtTelefono.getText() == null            || txtTelefono.getText().equals("")                )    {

            showAlert(
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

                    restaurantMgr.addRestaurant(name, nombreFantasia,contrasena, cuentaBancaria, ruc, email, telefono,
                            direccion, barrioMgr.getBarrio(barrio));


                    showAlert("Restaurante agregado", "Se agrego con exito el restaurante!");

                    cerrar(event);

                } catch(InvalidUserInformation invalidUserInformation) {
                    showAlert(
                            "Informacion invalida !",
                            "Se encontro un error en los datos ingresados.");
                } catch (UserAlreadyExists userAlreadyExists){
                    showAlert(
                            "Restaurante ya registrado !",
                            "El Restaurante indicado ya ha sido registrado en el sistema).");

                }


            }catch (NumberFormatException e) {

                showAlert(
                        "Datos incorrectos !",
                        "El RUC no tiene el formato esperado (numerico).");

            }

        }
    }



    @FXML
    void cerrar(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }


    private void showAlert(String title, String contextText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contextText);
        alert.showAndWait();
    }
}

