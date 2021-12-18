package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.connection.ConnectionApplication;
import com.example.tp_blumestein_esnault.donnees.Reservation;
import com.example.tp_blumestein_esnault.inscription.InscriptionApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button reserverButton;
    private Button userReservationButton;
    private Button refreshButton;


    @FXML
    public void login() throws IOException {
        new ConnectionApplication().start(new Stage());
    }
    public void register() throws IOException {
        new InscriptionApplication().start(new Stage());
    }
}