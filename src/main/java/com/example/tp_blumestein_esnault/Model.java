package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.donnees.Reservation;
import com.example.tp_blumestein_esnault.donnees.Salle;
import com.example.tp_blumestein_esnault.donnees.Utilisateur;

import java.sql.*;
import java.time.LocalDateTime;

public class Model {
    private static Connection conn;

    public Model(Connection conn) {
        this.conn = conn;
    }

    //USER

    public void addUser(String nom,String prenom) {


        String query = "INSERT INTO utilisateur VALUES (?, ?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            pstmt.setString(2,nom);
            pstmt.setString(3, prenom);
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void getUser(int id) throws SQLException {

        Statement s;
        String query = "SELECT Nom,Prenom FROM utilisateur WHERE idUtilisateur=?";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Utilisateur u = new Utilisateur(id, rs.getString("Nom"), rs.getString("Prenom"));
            }

    }

    public void updateUser(int id,String nom,String prenom) {

        String query = "UPDATE utilisateur SET Nom=?,Prenom=? WHERE idUtilisateur=(?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setInt(3, id);
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delUser(int id) throws SQLException {

        Statement s;
        String query = "DELETE FROM utilisateur WHERE idUtilisateur=(?) ;";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);
        {

            stmt.setInt(1, id);

            stmt.execute();

        }
    }


    //Salle

    public void addSalle(String nom) {


        String query = "INSERT INTO salle VALUES (?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            pstmt.setString(2,nom);
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void getSalle(int id) throws SQLException {

        Statement s;
        String query = "SELECT Nom_Salle FROM salle WHERE idSalle=?";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Salle salle = new Salle(id, rs.getString("Nom_Salle"));
        }

    }

    public void updateSalle(int id,String nom) {

        String query = "UPDATE salle SET Nom_Salle=? WHERE idSaller=(?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nom);
            pstmt.setInt(2, id);
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delSalle(int id) throws SQLException {

        Statement s;
        String query = "DELETE FROM salle WHERE idSalle=(?) ;";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);
        {

            stmt.setInt(1, id);

            stmt.execute();

        }
    }


    //Reservation

    public void addReservation(LocalDateTime debut, LocalDateTime fin) {


        String query = "INSERT INTO reservation VALUES (?, ?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            pstmt.setTimestamp(2,debut);
            pstmt.setTimestamp(3, fin);
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void getReservation(int id) throws SQLException {

        Statement s;
        String query = "SELECT Nom,Prenom FROM reservation WHERE idReservation=?";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Reservation = new Reservation(id, rs.getString("Debut_Reservation"), rs.getString("Fin_Reservation"),rs.getInt("Id_Utilisateur"),rs.getInt("Id_Salle"));
        }

    }

    public void updateReservation(int id,String nom,String prenom) {

        String query = "UPDATE reservation SET Nom=?,Prenom=? WHERE idReservation=(?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setInt(3, id);
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void delreservation(int id) throws SQLException {

        Statement s;
        String query = "DELETE FROM reservation WHERE idReservation=(?) ;";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);
        {

            stmt.setInt(1, id);

            stmt.execute();

        }
    }

}
