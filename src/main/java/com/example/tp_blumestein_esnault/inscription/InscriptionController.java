package com.example.tp_blumestein_esnault.inscription;

import com.example.tp_blumestein_esnault.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class InscriptionController {


    @FXML
    private TextField name,firstname,password=new TextField();
    @FXML
    private Button registerbutton;
    @FXML
    public void signin() throws SQLException {
    Model.addUser(name.getText(),firstname.getText(),password.getText());
    Stage stage = (Stage) registerbutton.getScene().getWindow();
    stage.close();
}

}