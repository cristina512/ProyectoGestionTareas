module org.example.gestiontareas {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens org.example.gestiontareas to javafx.fxml;
    exports org.example.gestiontareas;
}