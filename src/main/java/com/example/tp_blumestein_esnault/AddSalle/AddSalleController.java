package com.example.tp_blumestein_esnault.AddSalle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.example.tp_blumestein_esnault.MainController;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddSalleController {

    @FXML
    private TextField nameSalle=new TextField();
    MainController mainController = new MainController();
    @FXML
    public void AddSalle() throws SQLException {
        mainController.addSalleSelection(nameSalle.getText());
        Stage stage = (Stage) nameSalle.getScene().getWindow();
        stage.close();
    }

}
