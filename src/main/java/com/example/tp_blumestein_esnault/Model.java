package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.donnees.*;

import java.sql.*;

public interface Model {
    Connection conn = Bdd.conn;
    Reservations reservations=new Reservations();
    Salles salles=new Salles();
    Utilisateurs utilisateurs=new Utilisateurs();


    //USER

    public static void addUser(String nom,String prenom,String password) {


        String query = "INSERT INTO utilisateur VALUES (?, ?, ?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            pstmt.setString(2,nom);
            pstmt.setString(3, prenom);
            pstmt.setString(4, password);
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void getUser(int id) throws SQLException {

        Statement s;
        String query = "SELECT Nom,Prenom,Password FROM utilisateur WHERE idUtilisateur=?";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Utilisateur u = new Utilisateur(id, rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Password"));
        }

    }

    public static void updateUser(int id,String nom,String prenom,String password) {

        String query = "UPDATE utilisateur SET Nom=?,Prenom=?,Password=? WHERE idUtilisateur=(?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3,password);
            pstmt.setInt(4, id);
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void delUser(int id) throws SQLException {

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

    public static void addSalle(Salle salle) {


        String query = "INSERT INTO salle VALUES (?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            pstmt.setString(2,salle.getNom_Salle());
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /*public static void getSalle(int id) throws SQLException {

        String query = "SELECT Nom_Salle FROM salle WHERE idSalle=?";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Salle salle = new Salle(id, rs.getString("Nom_Salle"));
        }
    }*/

    public static Salle getSalle(int id) throws SQLException {

        String query = "SELECT Nom_Salle FROM salle WHERE idSalle=?";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        /*while(rs.next()) {
            Salle salle = new Salle(id, rs.getString("Nom_Salle"));
        }*/
        if (rs != null){
            return new Salle(id, rs.getString("Nom_Salle"));
        }
        else return null;

    }

    public static void updateSalle(Salle salle) {

        String query = "UPDATE salle SET Nom_Salle=? WHERE idSaller=(?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, salle.getNom_Salle());
            pstmt.setInt(2, salle.getId_Salle());
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void delSalle(Salle salle) throws SQLException {

        String query = "DELETE FROM salle WHERE idSalle=(?) ;";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);
        {

            stmt.setInt(1, salle.getId_Salle());

            stmt.execute();

        }
    }


    //Reservation

    public static void addReservation(Reservation reservation) {


        String query = "INSERT INTO reservation VALUES (?, ?, ?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
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

    public static void getReservation(int id) throws SQLException {

        String query = "SELECT Nom,Prenom FROM reservation WHERE idReservation=?";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Reservation reservation= new Reservation(id, rs.getTimestamp("Debut_Reservation").toLocalDateTime(), rs.getTimestamp("Fin_Reservation").toLocalDateTime(),salles.getSalles().get(rs.getInt("Id_Utilisateur")),utilisateurs.getUtilisateurs().get(rs.getInt("Id_Utilisateur")));
        }

    }

    public static void updateReservation(Reservation reservation) {

        String query = "UPDATE reservation SET Debut_Reservation=?,Fin_Reservation=?,Id_Salle=? WHERE idReservation=(?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setTimestamp(1,Timestamp.valueOf(reservation.getDebut_Reservation()));
            pstmt.setTimestamp(2, Timestamp.valueOf(reservation.getFin_Reservation()));
            pstmt.setInt(3,reservation.getSalle().getId_Salle());
            pstmt.setInt(4, reservation.getId_Reservation());
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void delreservation(Reservation reservation) throws SQLException {

        String query = "DELETE FROM reservation WHERE idReservation=(?) ;";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);
        {

            stmt.setInt(1, reservation.getId_Reservation());

            stmt.execute();

        }
    }

}
