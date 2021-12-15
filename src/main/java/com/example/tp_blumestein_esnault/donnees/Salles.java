package com.example.tp_blumestein_esnault.donnees;

import java.util.HashMap;

public class Salles {
    private HashMap<Integer,Salle> salles;

    public Salles() {
        this.salles = new HashMap<>();
    }


    public HashMap<Integer, Salle> getSalles() {
        return salles;
    }
    public void addSalle(Salle salle){
        salles.put(salle.getId_Salle(),salle);
    }
}
