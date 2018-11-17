package uy.edu.um.bbticg4.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.bbticg4.service.RestaurantMgr;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.math.BigDecimal;

@Component
public class DeudaVentanaController {

    @Autowired
    private RestaurantMgr restoMgr;

    private Restaurant resto;

    @FXML
    private Text smallLoan;

    @FXML
    public void initialize(){

        smallLoan.setText("$ "+resto.getDeuda());
    }

    @FXML
    void cancel(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void payDebt(ActionEvent event) {

        resto.setDeuda(BigDecimal.valueOf(0.00));
        smallLoan.setText("$ "+resto.getDeuda());
        restoMgr.updateResto(resto);

    }

    @FXML
    void update(ActionEvent event) {

        smallLoan.setText("$ "+resto.getDeuda());

    }

    public Restaurant getResto() {
        return resto;
    }

    public void setResto(Restaurant resto) {
        this.resto = resto;
    }
}