package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.connection.ConnectionApplication;
import com.example.tp_blumestein_esnault.donnees.Salle;
import com.example.tp_blumestein_esnault.donnees.Utilisateur;
import com.example.tp_blumestein_esnault.inscription.InscriptionApplication;
import com.example.tp_blumestein_esnault.AddSalle.AddSalleApplication;
import com.example.tp_blumestein_esnault.DelSalle.DelSalleApplication;
import com.example.tp_blumestein_esnault.donnees.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.control.Button;
import javafx.util.converter.LocalDateTimeStringConverter;

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
    @FXML
    public ArrayList<MenuItem> sallesItems=new ArrayList<>();

    private LocalDateTime currentDebut_Reservation;
    private LocalDateTime currentFin_Reservation;
    private LocalDate currentJour;
    private LocalTime currentHeureDebut;
    private LocalTime currentHeureFin;
    private Salle currentSalle;
    private Utilisateur currentUtilisateur;
    public Salles salles=Model.salles;
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
        MenuItem newSalle = new MenuItem(salleName);
        salleButton.getItems().addAll(newSalle);
        newSalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                salleButton.setText(event.getTarget().toString());
                setCurSalle(event);
            }
        });;
    }

    public void deleteSalle() throws IOException {
        new DelSalleApplication().start(new Stage());
    }

    public void initializeText() {
        textZone.getChildren().add(new Text("Ici apparaîssent les réservations"));
    }

    public void initializeSalles() throws SQLException {
        //initialize salle selection button
        int i;
        for (i=1; i< salles.getSalles().size()+1;i++){
            sallesItems.add(new MenuItem(salles.getSalles().get(i).getNom_Salle()));
            salleButton.getItems().add(sallesItems.get(i-1));
            int finalI = i;
            sallesItems.get(i-1).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    salleButton.setText(sallesItems.get(finalI-1).getText());
                    setCurSalle(event);
                }
            });
        }
    }


    public void setCurSalle(ActionEvent actionEvent) {
        for (int i=1; i < salles.getSalles().size()+1;i++){ //go through the hashmap
            if(salles.getSalles().get(i).getNom_Salle() == salleButton.getText()){ //hashmap value text match button text
                currentSalle = salles.getSalles().get(i);

                textZone.getChildren().add(new Text("Salle sélectionnée :" + currentSalle.getNom_Salle()));
            }
        }
    }

    public void addReservation(ActionEvent actionEvent) throws SQLException {
        currentJour = datePicker.getValue();
        currentDebut_Reservation.of(currentJour, currentHeureDebut);
        currentDebut_Reservation.of(currentJour, currentHeureFin);
        Reservation toAddReservation = new Reservation(currentDebut_Reservation, currentFin_Reservation, currentSalle, currentUtilisateur);
        Model.addReservation(toAddReservation);
        reservations.addReservation(toAddReservation);
    }

    public void selectUserReservations(ActionEvent actionEvent) throws SQLException {
        Model.getReservationByUser(currentUtilisateur);
    }

    public void setCurHour(ActionEvent actionEvent) {
        //heureButton.setText(actionEvent.getTarget().getClass().getText());
        String creneau = heureButton.getText();
        switch (creneau){
            case "8h15-10h15" :
                currentHeureDebut.of(8, 15);
                currentHeureFin.of(10, 15);
                textZone.getChildren().add(new Text("Créneau sélectionné : 8h15-10h15"));

            case "10h30-12h30" :
                currentHeureDebut.of(10, 30);
                currentHeureFin.of(12, 30);
                textZone.getChildren().add(new Text("Créneau sélectionné : 10h30-12h30"));


            case "14h00-16h00" :
                currentHeureDebut.of(14, 0);
                currentHeureFin.of( 16, 0);
                textZone.getChildren().add(new Text("Créneau sélectionné : 14h00-16h00"));


            case "16h15-18h15" :
                currentHeureDebut.of(16, 15);
                currentHeureFin.of( 18, 15);
                textZone.getChildren().add(new Text("Créneau sélectionné : 16h15-18h15"));

        }
    }
}