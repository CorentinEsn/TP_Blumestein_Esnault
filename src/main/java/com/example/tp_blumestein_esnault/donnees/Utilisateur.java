package com.example.tp_blumestein_esnault.donnees;
import javax.persistence.*;

import com.example.tp_blumestein_esnault.DAO;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Transient
    private static Utilisateur utilisateurInstance = new Utilisateur();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Utilisateur() {
        this.password = null;
        Id_Utilisateur=0;
        Nom_Utilisateur =null;
        Prenom_Utilisateur=null;
        this.current=false;
    }
    public static Utilisateur getInstance() {
        if (utilisateurInstance == null) {
            utilisateurInstance = new Utilisateur();
        }
        return utilisateurInstance;
    }
    public static void initialize() {
        DAO utilisateurDAO = new DAO(Utilisateur.class);
        if (utilisateurDAO.getAll().isEmpty()) {
            utilisateurDAO.persist(Salle.getInstance());
        } else {
            Utilisateur.getInstance().setId_Utilisateur(0);
            Utilisateur.getInstance().setNom_Utilisateur((String) utilisateurDAO.getColumn(0, "Nom"));
            Utilisateur.getInstance().setPrenom_Utilisateur((String) utilisateurDAO.getColumn(0, "Prenom"));
            Utilisateur.getInstance().setPassword((String) utilisateurDAO.getColumn(0, "password"));
        }
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

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
