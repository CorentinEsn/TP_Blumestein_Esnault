package com.example.tp_blumestein_esnault.donnees;

public class Salle {
    private int Id_Salle;
    private String Nom_Salle;

    public Salle(int id,String nom) {
        Nom_Salle=nom;
        Id_Salle=id;
    }
    public Salle(String nom) {
        Nom_Salle=nom;
        Id_Salle=0;
    }

    public int getId_Salle() {
        return Id_Salle;
    }

    public void setId_Salle(int id_Salle) {
        Id_Salle = id_Salle;
    }

    public String getNom_Salle() {
        return Nom_Salle;
    }

    public void setNom_Salle(String nom_Salle) {
        Nom_Salle = nom_Salle;
    }
}
