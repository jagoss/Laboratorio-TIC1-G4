import javafx.fxml.FXML;
import javafx.scene.control.ListView;

@COMPONENT
public class ReservasEntrantesController {

    @FXML
    private ListView<Reserva> listaReservasEntrantes;


    ObservableList<Restaurant> resultados = FXCollections.observableArrayList();

            for (int i = 0; i < restoPorBarrio.size(); i++) {
        resultados.add(restoPorBarrio.get(i));
    }
            listaRestaurantes.setItems(resultados);

            listaRestaurantes.setCellFactory(new Callback<ListView<Restaurant>, ListCell<Restaurant>>() {
        @Override
        public ListCell<Restaurant> call(ListView<Restaurant> listView) {
            return new CustomListCell();
        }
    });
}
