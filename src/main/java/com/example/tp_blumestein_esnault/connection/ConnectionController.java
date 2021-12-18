package com.example.tp_blumestein_esnault.connection;

import com.example.tp_blumestein_esnault.Model;
import com.example.tp_blumestein_esnault.donnees.Reservation;
import com.example.tp_blumestein_esnault.donnees.Salle;
import com.example.tp_blumestein_esnault.donnees.Utilisateur;
import com.example.tp_blumestein_esnault.donnees.Utilisateurs;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectionController {


    @FXML
    private TextField name,password=new TextField();
@FXML
    public void connect(){
    for (int i=1;i<Model.utilisateurs.getUtilisateurs().size()+1;i++){


        if (Model.utilisateurs.getUtilisateurs().get(i).getNom_Utilisateur().compareTo(name.getText())==0&&Model.utilisateurs.getUtilisateurs().get(i).getPassword().compareTo(password.getText())==0){
            Model.utilisateurs.getUtilisateurs().get(i).setCurrent(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès!");
            alert.setHeaderText("Connexion réussie");
            alert.showAndWait();
            Stage stage = (Stage) name.getScene().getWindow();
            stage.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setHeaderText("Connexion impossible");
            alert.setContentText("Utilisateur ou mot de passe introuvable");
            alert.showAndWait();
        }

    }

}

}