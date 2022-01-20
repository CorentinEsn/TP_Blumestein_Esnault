module com.example.tp_blumestein_esnault {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;

    opens com.example.tp_blumestein_esnault;
    opens com.example.tp_blumestein_esnault.connection;
    opens com.example.tp_blumestein_esnault.donnees;
    opens com.example.tp_blumestein_esnault.inscription;
    opens com.example.tp_blumestein_esnault.AddSalle;
    opens com.example.tp_blumestein_esnault.DelSalle;

    exports com.example.tp_blumestein_esnault.donnees;
    exports com.example.tp_blumestein_esnault.connection to javafx.fxml;
    exports com.example.tp_blumestein_esnault.inscription to javafx.fxml;
    exports com.example.tp_blumestein_esnault.AddSalle to javafx.fxml;
    exports com.example.tp_blumestein_esnault.DelSalle to javafx.fxml;
}