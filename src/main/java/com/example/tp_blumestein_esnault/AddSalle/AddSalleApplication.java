package com.example.tp_blumestein_esnault.AddSalle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AddSalleApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddSalle-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 270, 325);
        stage.setTitle("Ajouter une salle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {

        launch();
    }
}