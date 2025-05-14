module org.example.gestiontareas {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;


    opens org.example.gestiontareas to javafx.fxml;
    opens org.example.gestiontareas.CONTROLLER to javafx.fxml;
    exports org.example.gestiontareas;
    exports org.example.gestiontareas.CONTROLLER to javafx.fxml;

}