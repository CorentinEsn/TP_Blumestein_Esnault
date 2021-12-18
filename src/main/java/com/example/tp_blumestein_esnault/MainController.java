package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.connection.ConnectionApplication;
import com.example.tp_blumestein_esnault.donnees.Salle;
import com.example.tp_blumestein_esnault.donnees.Utilisateur;
import com.example.tp_blumestein_esnault.inscription.InscriptionApplication;
import com.example.tp_blumestein_esnault.AddSalle.AddSalleApplication;
import com.example.tp_blumestein_esnault.DelSalle.DelSalleApplication;
import com.example.tp_blumestein_esnault.donnees.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;

import javafx.scene.control.Button;

public class MainController {

    @FXML
    private MenuButton salleButton;
    @FXML
    private MenuButton heureButton;
    @FXML
    private DatePicker datePicker;
    @FXML
    private SplitMenuButton reserverButton;
    @FXML
    private Button userReservationButton;
    @FXML
    public TextFlow textZone;

    private LocalDateTime currentDebut_Reservation;
    private LocalDateTime currentFin_Reservation;
    private Salle currentSalle;
    private Utilisateur currentUtilisateur;
    public Salles salles;
    public Reservations reservations;

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

    public void addSalleSelection(String salleName) throws SQLException {
        MenuButton salleButton = new MenuButton();
        Model.addSalle(new Salle(salleName));
        salleButton.getItems().addAll(new MenuItem(salleName));
    }

    public void deleteSalle() throws IOException {
        new DelSalleApplication().start(new Stage());
    }

    public void initializeText() {
        textZone.getChildren().add(new Text("Ici apparaîssent les réservations"));
    }

    public void initializeSalles() throws SQLException {
        //initialize hashmap
        int i = 1;
        while (Model.getSalle(i) != null){
            Salle salleToAdd = Model.getSalle(i);

            //initialize hashmap
            salles = new Salles();
            salles.addSalle(salleToAdd);
            //initialize salle selection button
            salleButton.getItems().add(new MenuItem(salleToAdd.getNom_Salle()));
        }
    }

    /*public void setCurSalle(ActionEvent actionEvent) {
        for (int i=0; i < salles.getSalles().size();i++){ //go through the hashmap
            if(salles.getSalles().get(i).getNom_Salle() == salleButton.getText()){ //hashmap value text match button text
                currentSalle = salles.getSalles().get(i);
            }
        }

    }*/

    /*public void addReservation(ActionEvent actionEvent) {
        Reservation toAddReservation = new Reservation(currentDebut_Reservation, currentFin_Reservation, currentSalle, currentUtilisateur);
        Model.addReservation(toAddReservation);
        reservations.addReservation(toAddReservation);
    }*/

    /*public void selectUserReservations(ActionEvent actionEvent) throws SQLException {
        Model.getReservation(currentUtilisateur);
    }*/

    //public void setCurHour(ActionEvent actionEvent) {}
}