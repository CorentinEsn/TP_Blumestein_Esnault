package com.example.tp_blumestein_esnault.DelSalle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class DelSalleApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DelSalle-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 270, 325);
        stage.setTitle("Supprimer une salle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {

        launch();
    }
}
