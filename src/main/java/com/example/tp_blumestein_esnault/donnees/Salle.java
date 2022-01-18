package com.example.tp_blumestein_esnault.donnees;
import javax.persistence.*;

import com.example.tp_blumestein_esnault.DAO;

import java.time.LocalDateTime;

@Entity
public class Salle {

    @Transient
    private static Salle salleInstance = new Salle();


    @Id
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
    public Salle() {
        Nom_Salle=null;
        Id_Salle=0;
    }

    public static Salle getInstance() {
        if (salleInstance == null) {
            salleInstance = new Salle();
        }
        return salleInstance;
    }
    public static void initialize() {
        DAO salleDAO = new DAO(Salle.class);
        if (salleDAO.getAll().isEmpty()) {
            salleDAO.persist(Salle.getInstance());
        } else {
            Salle.getInstance().setId_Salle(0);
            Salle.getInstance().setNom_Salle((String) salleDAO.getColumn(0, "Nom_Reservation"));
        }
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
