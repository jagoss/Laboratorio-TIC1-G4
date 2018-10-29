package uy.edu.um;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uy.edu.um.bbticg4.ui.controllers.InicioAppController;
import static javafx.application.Application.launch;

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
        primaryStage.setScene(new Scene(root));
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
