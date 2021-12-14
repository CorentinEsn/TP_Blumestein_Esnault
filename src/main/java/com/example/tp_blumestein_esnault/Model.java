package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.donnees.Utilisateur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Model {
    public static void addUser(String nom,String prenom) {

        Connection conn=Bdd.conn;
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

    public static void getUser(int id) throws SQLException {

        Statement s;
        Connection conn = Bdd.conn;
        String query = "SELECT * FROM utilisateur WHERE idUtilisateur=(?) ;";


        //create a statement
        PreparedStatement stmt = conn.prepareStatement(query);
        {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            Utilisateur u = new Utilisateur(id, rs.getString("Nom"), rs.getString("Prenom"));

        }
    }
}
