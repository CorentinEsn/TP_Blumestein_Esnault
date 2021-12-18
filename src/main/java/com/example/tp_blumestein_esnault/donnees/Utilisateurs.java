package com.example.tp_blumestein_esnault.donnees;

import java.util.HashMap;

public class Utilisateurs {
    private final HashMap<Integer,Utilisateur> utilisateurs;

    public Utilisateurs() {
        this.utilisateurs = new HashMap<>();
    }

    public HashMap<Integer, Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
    public void addUtilisateur(Utilisateur utilisateur){
        utilisateurs.put(utilisateur.getId_Utilisateur(),utilisateur);
    }
}
