package uy.edu.um.bbticg4.ui.controllers;

@Component
public class HistorialReservasController {

    @Autowired
    private ReservaMgr reservaMgr;

    private List<Reserva> listaReservas = new LinkedList<>();

    @FXML
    private ListView<Reserva> Historial;

    private Restaurant resto;


    @FXML
    void displayReservas(ActionEvent event) {

        listaReservas = reservaMgr.getReservas(resto);

        ObservableList<Reserva> reservas = FXCollections.observableArrayList();

        for (int i = 0; i < listaReservas.size(); i++) {
            if (listaReservas.get(i).isFinalizada == true) {
                reservas.add(listaReservas.get(i));
            }
        }
        Historial.setItems(reservas);
        Historial.setCellFactory(new Callback<ListView<Reserva>, ListCell<Reserva>>() {
            @Override
            public ListCell<Reserva> call(ListView<Reserva> listView) {
                return new CustomListCellHistorial();
            }
        });
    }

    public void setResto(Restaurant resto){this.resto = resto;}

    public  Restaurant getResto(){return resto;}
}

}
