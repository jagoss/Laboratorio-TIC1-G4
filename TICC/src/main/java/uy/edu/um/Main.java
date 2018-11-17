package uy.edu.um;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import uy.edu.um.bbticg4.ui.controllers.InicioAppController;
import uy.edu.um.bbticg4.ui.controllers.LogInController;

import java.awt.*;

@SpringBootApplication
public class Main extends Application{

    private static ConfigurableApplicationContext context;

    private FXMLLoader fxmlLoader;

    private Parent root;

    @Override
    public void init() throws Exception {
        Main.context = SpringApplication.run(Main.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        root = fxmlLoader.load(InicioAppController.class.getResourceAsStream("InicioApp.fxml"));
        primaryStage.setResizable(false);
        Scene scenePrincipal = new Scene(root);
        scenePrincipal.getStylesheets().add("uy/edu/um/bbticg4/ui/images/pagPrincipal.css");
        primaryStage.setScene(scenePrincipal);
        primaryStage.show();

    }

    @Override
    public void stop() { Main.getContext().close();   }

    public static void main(String[] args) {
        launch(args);
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}
