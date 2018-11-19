package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.Main;
import uy.edu.um.bbticg4.exceptions.InvalidInformation;
import uy.edu.um.bbticg4.exceptions.TipoComidaAlreadyExists;
import uy.edu.um.bbticg4.service.BarrioMgr;
import uy.edu.um.bbticg4.service.TipoComidaMgr;

import java.io.IOException;

@Component
public class InicioAppController {

    @Autowired
    private BarrioMgr barrioMgr;

    @Autowired
    private TipoComidaMgr tipoComidaMgr;

    @FXML
    private Button signInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    public void initialize() throws InvalidInformation, TipoComidaAlreadyExists {
        if(barrioMgr.countBarrios()== 0){

            barrioMgr.addBarrio("Pocitos");
            barrioMgr.addBarrio("Malvin Norte");
            barrioMgr.addBarrio("Buceo");
            barrioMgr.addBarrio("Aguada");
            barrioMgr.addBarrio("Barrio Sur");
            barrioMgr.addBarrio("Carrasco");
            barrioMgr.addBarrio("Centro");
            barrioMgr.addBarrio("Cerro");
            barrioMgr.addBarrio("Cordon");
            barrioMgr.addBarrio("Parque Rodo");
            barrioMgr.addBarrio("Maroñas");
            barrioMgr.addBarrio("La Unión");
            barrioMgr.addBarrio("Barrio Capurro");
            barrioMgr.addBarrio("Peñarol");
            barrioMgr.addBarrio("Punta Gorda");
        }

        if(tipoComidaMgr.count() == 0){

            tipoComidaMgr.addTipoComida(1,"Parrilla");
            tipoComidaMgr.addTipoComida(2,"Pasta");
            tipoComidaMgr.addTipoComida(3,"Pizza");
            tipoComidaMgr.addTipoComida(4,"Arabe");
            tipoComidaMgr.addTipoComida(5,"Empanadas");
            tipoComidaMgr.addTipoComida(6,"Chivito");
            tipoComidaMgr.addTipoComida(7,"China");
            tipoComidaMgr.addTipoComida(8,"Celiaco");
            tipoComidaMgr.addTipoComida(9,"Cafe");
            tipoComidaMgr.addTipoComida(10,"Ensaladas");
            tipoComidaMgr.addTipoComida(11,"Hamburguesa");
            tipoComidaMgr.addTipoComida(12,"Milanesas");
            tipoComidaMgr.addTipoComida(13,"Pescado");
            tipoComidaMgr.addTipoComida(14, "Mejicana");
            tipoComidaMgr.addTipoComida(15,"Sushi");
            tipoComidaMgr.addTipoComida(16,"Otros");
        }
    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("RegistroCliente.fxml"));
        Stage stage = new Stage();
        Scene sceneLogIn = new Scene(root);
        sceneLogIn.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(sceneLogIn);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void signIn(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);
        Parent root = fxmlLoader.load(LogInController.class.getResourceAsStream("LogIn.fxml"));
        Stage stage = new Stage();
        Scene sceneLogIn = new Scene(root);
        sceneLogIn.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        stage.setScene(sceneLogIn);
        stage.setResizable(false);
        stage.show();

        Node source = (Node)  event.getSource();
        stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }

}
