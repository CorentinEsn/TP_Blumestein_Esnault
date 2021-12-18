package com.example.tp_blumestein_esnault.donnees;

import java.util.HashMap;

public class Reservations {
    private final HashMap<Integer,Reservation> reservations;

    public Reservations() {
        this.reservations = new HashMap<>();
    }

    public HashMap<Integer, Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation){
        reservations.put(reservation.getId_Reservation(),reservation);
    }
}
