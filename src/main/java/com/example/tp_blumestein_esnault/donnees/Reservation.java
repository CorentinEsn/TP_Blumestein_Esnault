package com.example.tp_blumestein_esnault.donnees;

import java.time.LocalDateTime;

public class Reservation {
    private int Id_Reservation;
    private LocalDateTime Debut_Reservation;
    private LocalDateTime Fin_Reservation;

    public Reservation(int id, LocalDateTime debut, LocalDateTime fin) {
        Id_Reservation =id;
        Debut_Reservation = debut;
        Fin_Reservation =fin;
    }
    public Reservation(LocalDateTime debut, LocalDateTime fin) {
        Id_Reservation = 0;
        Debut_Reservation = debut;
        Fin_Reservation = fin;
    }

    public int getId_Salle() {
        return Id_Reservation;
    }

    public void setId_Salle(int id_Salle) {
        Id_Reservation = id_Salle;
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
}
