package uy.edu.um.bbticg4.ui.tools;

import javafx.scene.control.Alert;
import org.springframework.stereotype.Service;

@Service
public class JavaFXTools {

    public void showAlert(String title, String contextText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contextText);
        alert.showAndWait();
    }

}
