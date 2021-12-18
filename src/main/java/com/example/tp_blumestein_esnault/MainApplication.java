package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.donnees.Reservations;
import com.example.tp_blumestein_esnault.donnees.Salle;
import com.example.tp_blumestein_esnault.donnees.Salles;
import com.example.tp_blumestein_esnault.donnees.Utilisateurs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import com.example.tp_blumestein_esnault.MainController;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 615, 400);
        MainController mainController = fxmlLoader.getController();
        stage.setTitle("Reservation de salles");
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
        Model.getAllUser();
        Model.getAllSalle();
        Model.getAllReservation();
        launch();




        Bdd.closeConnection();
    }
}