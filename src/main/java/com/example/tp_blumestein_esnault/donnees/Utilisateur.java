package com.example.tp_blumestein_esnault.donnees;

public class Utilisateur {
    private int Id_Utilisateur;
    private String Nom_Utilisateur;
    private String Prenom_Utilisateur;

    public Utilisateur(int id, String nom,String prenom) {
        Id_Utilisateur=id;
        Nom_Utilisateur =nom;
        Prenom_Utilisateur=prenom;
    }
    public Utilisateur(String nom,String prenom) {
        Id_Utilisateur=0;
        Nom_Utilisateur =nom;
        Prenom_Utilisateur=prenom;
    }

    public int getId_Salle() {
        return Id_Utilisateur;
    }

    public void setId_Salle(int id_Salle) {
        Id_Utilisateur = id_Salle;
    }

    public String getNom_Utilisateur() {
        return Nom_Utilisateur;
    }

    public void setNom_Utilisateur(String nom_Utilisateur) {
        Nom_Utilisateur = nom_Utilisateur;
    }

    public String getPrenom_Utilisateur() {
        return Prenom_Utilisateur;
    }

    public void setPrenom_Utilisateur(String prenom_Utilisateur) {
        Prenom_Utilisateur = prenom_Utilisateur;
    }
}
