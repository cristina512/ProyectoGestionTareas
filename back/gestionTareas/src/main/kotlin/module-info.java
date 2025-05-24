module com.example.gestiontareas {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;
    requires java.desktop;

    opens com.example.gestiontareas to javafx.fxml;
    opens com.example.gestiontareas.Presentacion to javafx.fxml;

    exports com.example.gestiontareas;
    exports com.example.gestiontareas.Presentacion;
}
