package com.example.tp_blumestein_esnault.donnees;

import java.time.LocalDateTime;

public class Reservation {
    private int Id_Reservation;
    private LocalDateTime Debut_Reservation;
    private LocalDateTime Fin_Reservation;
    private Salle Salle;
    private Utilisateur Utilisateur;

    public Reservation(int id, LocalDateTime debut, LocalDateTime fin, Salle salle, Utilisateur utilisateur) {
        Id_Reservation =id;
        Debut_Reservation = debut;
        Fin_Reservation =fin;
        Salle = salle;
        Utilisateur = utilisateur;
    }
    public Reservation(LocalDateTime debut, LocalDateTime fin, Salle salle, Utilisateur utilisateur) {
        Id_Reservation = 0;
        Debut_Reservation = debut;
        Fin_Reservation = fin;
        Salle = salle;
        Utilisateur = utilisateur;
    }

    public int getId_Reservation() {
        return Id_Reservation;
    }

    public void setId_Reservation(int id_reservation) {
        Id_Reservation = id_reservation;
    }

    public LocalDateTime getDebut_Reservation() {
        return Debut_Reservation;
    }

    public void setDebut_Reservation(LocalDateTime debut_Reservation) {
        Debut_Reservation = debut_Reservation;
    }

    public LocalDateTime getFin_Reservation() {
        return Fin_Reservation;
    }

    public void setFin_Reservation(LocalDateTime fin_Reservation) {
        Fin_Reservation = fin_Reservation;
    }

    public Salle getSalle() {
        return Salle;
    }

    public void setSalle(Salle salle) {
        Salle = salle;
    }

    public Utilisateur getUtilisateur() {
        return Utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        Utilisateur = utilisateur;
    }
}
