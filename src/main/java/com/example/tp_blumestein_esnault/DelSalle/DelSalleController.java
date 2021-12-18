package com.example.tp_blumestein_esnault.DelSalle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import com.example.tp_blumestein_esnault.MainController;

public class DelSalleController {

    @FXML
    private MenuButton nameSalle=new MenuButton();
    MainController mainController = new MainController();
    @FXML
    public void DelSalle(ActionEvent actionEvent) {
        //mainController.deleteSalle(nameSalle.getText());
    }
}