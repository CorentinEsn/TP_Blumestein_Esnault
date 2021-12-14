package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.donnees.Utilisateur;

import java.sql.*;

public class Model {
    private static Connection conn;

    public Model(Connection conn) {
        this.conn = conn;
    }


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
}
