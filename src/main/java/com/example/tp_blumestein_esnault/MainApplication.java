package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.donnees.Salle;
import com.example.tp_blumestein_esnault.donnees.Salles;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 615, 400);
        MainController mainController = fxmlLoader.getController();
        stage.setTitle("Reservation de salles");

        //initialization of Salle selections
        Salles salles = new Salles();
        HashMap<Integer, Salle> sallesArray = salles.getSalles();
        for (Salle salle : sallesArray.values()){
            mainController.addSalleSelection(salle.getNom_Salle());
        }

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Bdd.initConnection();
        launch();

        Bdd.closeConnection();
    }
}