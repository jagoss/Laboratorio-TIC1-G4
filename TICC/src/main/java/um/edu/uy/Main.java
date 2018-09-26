package um.edu.uy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uy.edu.um.UI.controllers.PrimeraPantallaController;

@SpringBootApplication
public class Main extends Application {

    private ConfigurableApplicationContext context;

    private FXMLLoader fxmlLoader;

    private Parent root;

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(Main.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(context::getBean);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        fxmlLoader.setLocation(PrimeraPantallaController.class.getResource("PrimeraPantalla.fxml"));

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
