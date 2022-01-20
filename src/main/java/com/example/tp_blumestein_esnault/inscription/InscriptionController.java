package com.example.tp_blumestein_esnault.inscription;

import com.example.tp_blumestein_esnault.donnees.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.tp_blumestein_esnault.DAO;

import java.sql.SQLException;

public class InscriptionController {


    @FXML
    private TextField name,firstname,password=new TextField();
    @FXML
    private Button registerbutton;
    private DAO<Utilisateur> dao = new DAO<Utilisateur>(Utilisateur.class);
    @FXML
    public void signin() throws SQLException {
        Utilisateur newUser = new Utilisateur(name.getText(),firstname.getText(),password.getText());
        dao.persist(newUser);
        Stage stage = (Stage) registerbutton.getScene().getWindow();
        stage.close();
    }

}