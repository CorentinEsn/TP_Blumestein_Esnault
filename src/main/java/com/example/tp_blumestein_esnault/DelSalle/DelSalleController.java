package com.example.tp_blumestein_esnault.DelSalle;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import com.example.tp_blumestein_esnault.MainController;

public class DelSalleController {

    @FXML
    private final MenuButton nameSalle=new MenuButton();
    MainController mainController = new MainController();
    @FXML
    public void DelSalle() {
        //mainController.deleteSalle(nameSalle.getText());
    }
}