package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.connection.ConnectionApplication;
import com.example.tp_blumestein_esnault.connection.ConnectionController;
import com.example.tp_blumestein_esnault.donnees.Reservation;
import com.example.tp_blumestein_esnault.inscription.InscriptionApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button reserverButton;
    private Button userReservationButton;
    @FXML
    private TableView<Reservation> calendrierReservations;

    @FXML
    public void login() throws IOException {
        new ConnectionApplication().start(new Stage());
    }
    public void register() throws IOException {
        new InscriptionApplication().start(new Stage());
    }

}