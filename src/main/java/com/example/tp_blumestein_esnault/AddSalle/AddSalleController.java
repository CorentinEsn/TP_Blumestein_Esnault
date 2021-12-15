package com.example.tp_blumestein_esnault.AddSalle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.example.tp_blumestein_esnault.MainController;

public class AddSalleController {

    @FXML
    private TextField nameSalle=new TextField();
    MainController mainController = new MainController();
    @FXML
    public void AddSalle(ActionEvent actionEvent) {
        mainController.addSalleSelection(nameSalle.getText());
    }

}
