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
import javafx.util.converter.LocalTimeStringConverter;

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

    private LocalDateTime currentDebut_Reservation=LocalDateTime.now();
    private LocalDateTime currentFin_Reservation=LocalDateTime.now();
    private LocalDate currentJour=LocalDate.now();
    private LocalTime currentHeureDebut=LocalTime.now();
    private LocalTime currentHeureFin=LocalTime.now();
    private final LocalDateTime refCurrentDateTime = currentDebut_Reservation;

    private Salle currentSalle;
    private Utilisateur currentUtilisateur;

    DAO<Utilisateur> userDao = new DAO<Utilisateur>(Utilisateur.class);
    DAO<Salle> salleDao = new DAO<Salle>(Salle.class);
    DAO<Reservation> reservationDao = new DAO<Reservation>(Reservation.class);

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
        salleDao.persist(new Salle(salleName));

        MenuItem newSalle = new MenuItem(salleName);
        salleButton.getItems().addAll(newSalle);
        newSalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                salleButton.setText(event.getTarget().toString());
                setCurSalle(event);
            }
        });
    }

    public void deleteSalle() throws IOException {
        new DelSalleApplication().start(new Stage());
    }

    public void initializeText() {
        textZone.getChildren().add(new Text("Ici apparaîssent les réservations\n"));
        for (int i=1;i<reservationDao.getAll().size()+1;i++){

            textZone.getChildren().add(new Text("Salle : "+reservationDao.get(i).getSalle().getNom_Salle()+
                    "\n Heure de début : "+reservationDao.get(i).getDebut_Reservation().toString()
                    +"\n Heure de fin : "+reservationDao.get(i).getFin_Reservation().toString()
                    +"\n Réservée par : "+reservationDao.get(i).getUtilisateur().getNom_Utilisateur()+" "
                    +reservationDao.get(i).getUtilisateur().getPrenom_Utilisateur()+"\n\n"));
        }
    }

    public void initializeSalles() throws SQLException {
        //initialize salle selection button
        int i;
        for (i=1; i< salleDao.getAll().size()+1;i++){
            sallesItems.add(new MenuItem(salleDao.get(i).getNom_Salle()));
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
        for (int i=1; i < salleDao.getAll().size()+1;i++){ //go through the hashmap
            if(salleDao.get(i).getNom_Salle() == salleButton.getText()){ //hashmap value text match button text
                currentSalle = salleDao.get(i);

                //textZone.getChildren().add(new Text("Salle sélectionnée :" + currentSalle.getNom_Salle()+"\n"));
                setText();
            }
        }
    }

    public void addReservation(ActionEvent actionEvent) throws SQLException {
        currentJour = datePicker.getValue();
        //System.out.println(currentHeureDebut);
        currentDebut_Reservation=LocalDateTime.of(currentJour, currentHeureDebut);
        currentFin_Reservation=LocalDateTime.of(currentJour, currentHeureFin);
        for (int i=1;i<userDao.getAll().size()+1;i++){
            if (userDao.get(i).isCurrent()){
                currentUtilisateur=userDao.get(i);
            }
        }
        Reservation toAddReservation = new Reservation(currentDebut_Reservation, currentFin_Reservation, currentSalle, currentUtilisateur);
        //System.out.println(currentUtilisateur.getId_Utilisateur());
        //System.out.println(currentUtilisateur.getNom_Utilisateur());
        reservationDao.persist(toAddReservation);
    }

    public void selectUserReservations(ActionEvent actionEvent) throws SQLException {
        /*for (int i=1;i<Model.utilisateurs.getUtilisateurs().size()+1;i++) {
            if (Model.utilisateurs.getUtilisateurs().get(i).isCurrent()) {
                currentUtilisateur = Model.utilisateurs.getUtilisateurs().get(i);
            }
        }
        Model.getReservationByUser(currentUtilisateur);*/
        setText();
    }

    public void setCurHour1(ActionEvent actionEvent){
        setCurHour(1);
    }
    public void setCurHour2(ActionEvent actionEvent){
        setCurHour(2);
    }
    public void setCurHour3(ActionEvent actionEvent){
        setCurHour(3);
    }
    public void setCurHour4(ActionEvent actionEvent){
        setCurHour(4);
    }
    public void setCurHour(int i) {
        switch (i) {
            case 1 -> {
                currentHeureDebut = LocalTime.of(8, 15);
                System.out.println(currentHeureDebut);
                currentHeureFin = LocalTime.of(10, 15);
                //textZone.getChildren().add(new Text("Créneau sélectionné : 8h15-10h15\n"));
                if (currentJour != null) {
                    setText();
                }
                heureButton.setText("8h15-10h15");
            }
            case 2 -> {
                currentHeureDebut = LocalTime.of(10, 30);
                currentHeureFin = LocalTime.of(12, 30);
                //textZone.getChildren().add(new Text("Créneau sélectionné : 10h30-12h30\n"));
                heureButton.setText("10h30-12h30");
                if (currentJour != null) {
                    setText();
                }
            }
            case 3 -> {
                currentHeureDebut = LocalTime.of(14, 0);
                currentHeureFin = LocalTime.of(16, 0);
                //textZone.getChildren().add(new Text("Créneau sélectionné : 14h00-16h00\n"));
                heureButton.setText("14h00-16h00");
                if (currentJour != null) {
                    setText();
                }
            }
            case 4 -> {
                currentHeureDebut = LocalTime.of(16, 15);
                currentHeureFin = LocalTime.of(18, 15);
                //textZone.getChildren().add(new Text("Créneau sélectionné : 16h15-18h15\n"));
                heureButton.setText("16h15-18h15");
                if (currentJour != null) {
                    setText();
                }
            }
        }
    }

    public void supprReservation(ActionEvent actionEvent) throws SQLException {
        //get all needed values to create a reservation to delete
        currentJour = datePicker.getValue();
        currentDebut_Reservation=LocalDateTime.of(currentJour, currentHeureDebut);
        currentFin_Reservation=LocalDateTime.of(currentJour, currentHeureFin);
        for (int i=1;i<userDao.getAll().size()+1;i++){
            if (userDao.get(i).isCurrent()){
                currentUtilisateur=userDao.get(i);
            }
        }
        Reservation toDelReservation = new Reservation(currentDebut_Reservation, currentFin_Reservation, currentSalle, currentUtilisateur);
        //looking in hashmap for the reservation to delete
        for (int i = 1; i< reservationDao.getAll().size(); i++ ){
            if(reservationDao.get(i)==toDelReservation){
                reservationDao.delete(reservationDao.get(i)); //delete reservation in database
            }
        }
    }

    public void setText(){
        textZone.getChildren().clear();
        int c = 0;
        //par salle
        if (currentSalle != null && currentUtilisateur == null && refCurrentDateTime == currentDebut_Reservation){
            c = 1;
        }
        //par date
        else if (currentSalle == null && currentUtilisateur == null && refCurrentDateTime != currentDebut_Reservation){
            c = 2;
        }
        //par utilisateur
        else if (currentSalle == null && currentUtilisateur != null && refCurrentDateTime == currentDebut_Reservation){
            c = 3;
        }
        //par salle et date
        else if (currentSalle != null && currentUtilisateur == null && refCurrentDateTime != currentDebut_Reservation){
            c = 4;
        }
        //par salle et utilisateur
        else if (currentSalle != null && currentUtilisateur != null && refCurrentDateTime == currentDebut_Reservation){
            c = 5;
        }
        //par date et utilisateur
        else if (currentSalle == null && currentUtilisateur != null && refCurrentDateTime != currentDebut_Reservation){
            c = 6;
        }
        //par salle et date et utilisateur
        else if (currentSalle != null && currentUtilisateur != null && refCurrentDateTime != currentDebut_Reservation){
            c = 7;
        }

        textZone.getChildren().add(new Text("Ici apparaîssent les réservations\n"+c));
        switch (c){
            case 1 :
                //par salle
                for (int i=1;i<reservationDao.getAll().size()+1;i++) {
                    if (reservationDao.get(i).getSalle() == currentSalle) {
                        textZone.getChildren().add(new Text("Salle : " + reservationDao.get(i).getSalle().getNom_Salle() +
                                "\n Heure de début : " + reservationDao.get(i).getDebut_Reservation().toString()
                                + "\n Heure de fin : " + reservationDao.get(i).getFin_Reservation().toString()
                                + "\n Réservée par : " + reservationDao.get(i).getUtilisateur().getNom_Utilisateur() + " "
                                + reservationDao.get(i).getUtilisateur().getPrenom_Utilisateur() + "\n\n"));

                    }
                }
                break;

            case 2 :
                //par date
                for (int i=1;i<reservationDao.getAll().size()+1;i++) {
                    if (reservationDao.get(i).getDebut_Reservation() == LocalDateTime.of(currentJour, currentHeureDebut)) {
                        textZone.getChildren().add(new Text("Salle : " + reservationDao.get(i).getSalle().getNom_Salle() +
                                "\n Heure de début : " + reservationDao.get(i).getDebut_Reservation().toString()
                                + "\n Heure de fin : " + reservationDao.get(i).getFin_Reservation().toString()
                                + "\n Réservée par : " + reservationDao.get(i).getUtilisateur().getNom_Utilisateur() + " "
                                + reservationDao.get(i).getUtilisateur().getPrenom_Utilisateur() + "\n\n"));

                    }
                }
                break;
            case 3 :
                //par utilisateur
                for (int i=1;i<reservationDao.getAll().size()+1;i++) {
                    if (reservationDao.get(i).getUtilisateur() == currentUtilisateur) {
                        textZone.getChildren().add(new Text("Salle : " + reservationDao.get(i).getSalle().getNom_Salle() +
                                "\n Heure de début : " + reservationDao.get(i).getDebut_Reservation().toString()
                                + "\n Heure de fin : " + reservationDao.get(i).getFin_Reservation().toString()
                                + "\n Réservée par : " + reservationDao.get(i).getUtilisateur().getNom_Utilisateur() + " "
                                + reservationDao.get(i).getUtilisateur().getPrenom_Utilisateur() + "\n\n"));

                    }
                }
                break;

            case 4 :
                //par salle et date
                for (int i=1;i<reservationDao.getAll().size()+1;i++) {
                    if (reservationDao.get(i).getSalle() == currentSalle && reservationDao.get(i).getDebut_Reservation() == LocalDateTime.of(currentJour, currentHeureDebut)) {
                        textZone.getChildren().add(new Text("Salle : " + reservationDao.get(i).getSalle().getNom_Salle() +
                                "\n Heure de début : " + reservationDao.get(i).getDebut_Reservation().toString()
                                + "\n Heure de fin : " + reservationDao.get(i).getFin_Reservation().toString()
                                + "\n Réservée par : " + reservationDao.get(i).getUtilisateur().getNom_Utilisateur() + " "
                                + reservationDao.get(i).getUtilisateur().getPrenom_Utilisateur() + "\n\n"));

                    }
                }
                break;

            case 5 :
                //par salle et utilisateur
                for (int i=1;i<reservationDao.getAll().size()+1;i++) {
                    if (reservationDao.get(i).getSalle() == currentSalle && reservationDao.get(i).getUtilisateur() == currentUtilisateur) {
                        textZone.getChildren().add(new Text("Salle : " + reservationDao.get(i).getSalle().getNom_Salle() +
                                "\n Heure de début : " + reservationDao.get(i).getDebut_Reservation().toString()
                                + "\n Heure de fin : " + reservationDao.get(i).getFin_Reservation().toString()
                                + "\n Réservée par : " + reservationDao.get(i).getUtilisateur().getNom_Utilisateur() + " "
                                + reservationDao.get(i).getUtilisateur().getPrenom_Utilisateur() + "\n\n"));

                    }
                }
                break;

            case 6 :
                //par date et utilisateur
                for (int i=1;i<reservationDao.getAll().size()+1;i++) {
                    if (reservationDao.get(i).getDebut_Reservation() == LocalDateTime.of(currentJour, currentHeureDebut) && reservationDao.get(i).getUtilisateur() == currentUtilisateur) {
                        textZone.getChildren().add(new Text("Salle : " + reservationDao.get(i).getSalle().getNom_Salle() +
                                "\n Heure de début : " + reservationDao.get(i).getDebut_Reservation().toString()
                                + "\n Heure de fin : " + reservationDao.get(i).getFin_Reservation().toString()
                                + "\n Réservée par : " + reservationDao.get(i).getUtilisateur().getNom_Utilisateur() + " "
                                + reservationDao.get(i).getUtilisateur().getPrenom_Utilisateur() + "\n\n"));

                    }
                }
                break;

            case 7 :
                //par salle et date et utilisateur
                for (int i=1;i<reservationDao.getAll().size()+1;i++) {
                    if (reservationDao.get(i).getSalle() == currentSalle && reservationDao.get(i).getDebut_Reservation() == LocalDateTime.of(currentJour, currentHeureDebut) && reservationDao.get(i).getUtilisateur() == currentUtilisateur) {
                        textZone.getChildren().add(new Text("Salle : " + reservationDao.get(i).getSalle().getNom_Salle() +
                                "\n Heure de début : " + reservationDao.get(i).getDebut_Reservation().toString()
                                + "\n Heure de fin : " + reservationDao.get(i).getFin_Reservation().toString()
                                + "\n Réservée par : " + reservationDao.get(i).getUtilisateur().getNom_Utilisateur() + " "
                                + reservationDao.get(i).getUtilisateur().getPrenom_Utilisateur() + "\n\n"));

                    }
                }
                break;
        }
    }
}