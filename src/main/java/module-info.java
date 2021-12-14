module com.example.tp_blumestein_esnault {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.tp_blumestein_esnault to javafx.fxml;
    exports com.example.tp_blumestein_esnault;
}