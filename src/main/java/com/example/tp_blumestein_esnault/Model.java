package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.donnees.*;

import java.sql.*;
import com.example.tp_blumestein_esnault.MainController;

public interface Model {
    Connection conn = Bdd.conn;
    Reservations reservations=new Reservations();
    Salles salles=new Salles();
    Utilisateurs utilisateurs=new Utilisateurs();

    //USER

    static void addUser(String nom, String prenom, String password) throws SQLException {
        String getIdMax = "SELECT MAX(idUtilisateur) FROM utilisateur";
        PreparedStatement stmt=conn.prepareStatement(getIdMax);

        ResultSet resultMax=stmt.executeQuery();
        int idMax=0;
        while(resultMax.next()) {
            idMax=resultMax.getInt(1);
        }

        String query = "INSERT INTO utilisateur VALUES (?, ?, ?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,idMax+1 );
            pstmt.setString(2,nom);
            pstmt.setString(3, prenom);
            pstmt.setString(4, password);
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    static void getAllUser() throws SQLException {
        Statement s;
        String query = "SELECT * FROM utilisateur";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Utilisateur u = new Utilisateur(rs.getInt(1), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Password"));
            utilisateurs.addUtilisateur(u);
        }
    }

    //Salle

    static void addSalle(Salle salle) throws SQLException{

        String getIdMax = "SELECT MAX(idSalle) FROM salle";
        PreparedStatement stmt=conn.prepareStatement(getIdMax);

        ResultSet resultMax=stmt.executeQuery();
        int idMax=0;
        while(resultMax.next()) {
            idMax=resultMax.getInt(1);
        }
        String query = "INSERT INTO salle VALUES (?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idMax+1);
            pstmt.setString(2,salle.getNom_Salle());
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    static void getAllSalle() throws SQLException {

        String query = "SELECT * FROM salle";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);


        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Salle salle = new Salle(rs.getInt("idSalle"), rs.getString("Nom_Salle"));
            salles.addSalle(salle);
        }

    }


    //Reservation

    static void addReservation(Reservation reservation) throws SQLException {

        String getIdMax = "SELECT MAX(idReservation) FROM reservation";
        PreparedStatement stmt=conn.prepareStatement(getIdMax);

        ResultSet resultMax=stmt.executeQuery();
        int idMax=0;
        while(resultMax.next()) {
            idMax=resultMax.getInt(1);
        }


        String query = "INSERT INTO reservation VALUES (?, ?, ?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idMax+1);
            pstmt.setTimestamp(2,Timestamp.valueOf(reservation.getDebut_Reservation()));
            pstmt.setTimestamp(3, Timestamp.valueOf(reservation.getFin_Reservation()));
            pstmt.setInt(4,reservation.getUtilisateur().getId_Utilisateur());
            pstmt.setInt(5,reservation.getSalle().getId_Salle());
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    static void getAllReservation() throws SQLException {

        String query = "SELECT * FROM reservation";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Reservation reservation= new Reservation(rs.getInt("idReservation"), rs.getTimestamp("Debut_Reservation").toLocalDateTime(), rs.getTimestamp("Fin_Reservation").toLocalDateTime(),salles.getSalles().get(rs.getInt("Id_Utilisateur")),utilisateurs.getUtilisateurs().get(rs.getInt("Id_Utilisateur")));
            reservations.addReservation(reservation);
        }

    }

    static void delreservation(Reservation reservation) throws SQLException {

        String query = "DELETE FROM reservation WHERE idReservation=(?) ;";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);
        {

            stmt.setInt(1, reservation.getId_Reservation());

            stmt.execute();

        }
    }



}
