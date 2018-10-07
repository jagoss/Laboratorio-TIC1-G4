package uy.edu.um;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uy.edu.um.bbticg4.ui.controllers.ClienteFinalFiltroController;

@SpringBootApplication
public class MainClienteFinalFiltro extends Application {

    private ConfigurableApplicationContext context;

    private FXMLLoader fxmlLoader;

    private Parent root;

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(MainClienteFinalFiltro.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(context::getBean);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        fxmlLoader.setLocation(ClienteFinalFiltroController.class.getResource(
                "ClienteFinalFiltro.fxml"));

        root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
