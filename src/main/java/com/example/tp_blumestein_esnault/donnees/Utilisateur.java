package com.example.tp_blumestein_esnault.donnees;

public class Utilisateur {
    private int Id_Utilisateur;
    private String Nom_Utilisateur;
    private String Prenom_Utilisateur;
    private String password;
    private boolean current;

    public Utilisateur(Integer id, String nom, String prenom, String password) {
        Id_Utilisateur=id;
        Nom_Utilisateur =nom;
        Prenom_Utilisateur=prenom;
        this.password = password;
        this.current=false;
    }
    public Utilisateur(String nom, String prenom, String password) {
        this.password = password;
        Id_Utilisateur=0;
        Nom_Utilisateur =nom;
        Prenom_Utilisateur=prenom;
        this.current=false;
    }

    public int getId_Utilisateur() {
        return Id_Utilisateur;
    }

    public void setId_Utilisateur(int id_Salle) {
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
