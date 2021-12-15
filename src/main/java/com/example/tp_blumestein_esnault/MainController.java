package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.connection.ConnectionApplication;
import com.example.tp_blumestein_esnault.donnees.Reservation;
import com.example.tp_blumestein_esnault.donnees.Salle;
import com.example.tp_blumestein_esnault.inscription.InscriptionApplication;
import com.example.tp_blumestein_esnault.AddSalle.AddSalleApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.control.Button;

public class MainController {

    @FXML
    private MenuButton salleButton;
    private MenuButton heureButton;
    private DatePicker datePicker;
    private Button reserverButton;
    private Button userReservationButton;
    private TextFlow textFlow;

    @FXML
    public void login() throws IOException {
        new ConnectionApplication().start(new Stage());
    }
    public void register() throws IOException {
        new InscriptionApplication().start(new Stage());
    }
    public void openAddSallePopup() throws IOException {
        new AddSalleApplication().start(new Stage());
    }

    public void addSalleSelection(String salleName){
        MenuButton salleButton = new MenuButton();
        Model.addSalle(new Salle(salleName));
        salleButton.getItems().addAll(new MenuItem(salleName));
    }

}