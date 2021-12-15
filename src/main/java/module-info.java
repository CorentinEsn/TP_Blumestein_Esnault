module com.example.tp_blumestein_esnault {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tp_blumestein_esnault to javafx.fxml;
    exports com.example.tp_blumestein_esnault;

    opens com.example.tp_blumestein_esnault.connection to javafx.fxml;
    exports com.example.tp_blumestein_esnault.connection;
    opens com.example.tp_blumestein_esnault.inscription to javafx.fxml;
    exports com.example.tp_blumestein_esnault.inscription;
}