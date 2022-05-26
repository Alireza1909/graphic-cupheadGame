module com.example.apcupheadazmayeshi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.apcupheadazmayeshi to javafx.fxml;
    exports com.example.apcupheadazmayeshi;
}