module com.example.apcupheadazmayeshi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.apcupheadazmayeshi to javafx.fxml;
    exports com.example.apcupheadazmayeshi;
    exports com.example.apcupheadazmayeshi.View;
    opens com.example.apcupheadazmayeshi.View to javafx.fxml;
}