package com.example.tp_blumestein_esnault.donnees;

import com.example.tp_blumestein_esnault.DAO;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class Reservation {
    @Transient
    private static Reservation reservationInstance = new Reservation();

    @Id
    @Column(name = "id")
    private int Id_Reservation;
    private LocalDateTime Debut_Reservation;
    private LocalDateTime Fin_Reservation;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Salle Salle;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
    public Reservation() {
        Id_Reservation =0;
        Debut_Reservation = null;
        Fin_Reservation =null;
        Salle = null;
        Utilisateur = null;
    }
    public static Reservation getInstance() {
        if (reservationInstance == null) {
            reservationInstance = new Reservation();
        }
        return reservationInstance;
    }
    public static void initialize(){
        DAO reservationDAO = new DAO(Reservation.class);
        if (reservationDAO.getAll().isEmpty()) {
            reservationDAO.persist(Reservation.getInstance());
        } else {
            Reservation.getInstance().setId_Reservation(0);
            Reservation.getInstance().setDebut_Reservation((LocalDateTime) reservationDAO.getColumn(0, "Debut_Reservation"));
            Reservation.getInstance().setFin_Reservation((LocalDateTime) reservationDAO.getColumn(0,"Fin_Reservation"));
        }
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
