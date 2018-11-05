import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Component
public class MenuInicioRestoController {

    @FXML
    private Button reservasEntrantes;

    @FXML
    private Button estadoReservas;

    @FXML
    private Button editarDatos;

    @FXML
    private Button Return;

    @FXML
    void Return(ActionEvent event) {

    }

    @FXML
    void editarDatos(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);

        Parent root = fxmlLoader.load(AdminRegistroRestauranteController.class.getResourceAsStream("RestoInfoEdit.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void estadoReservas(ActionEvent event) {

    }

    @FXML
    void reservasEntrantes(ActionEvent event) {

    }

}
