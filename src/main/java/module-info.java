module com.lumiere.lum {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lumiere.lum to javafx.fxml;
    exports com.lumiere.lum;
}