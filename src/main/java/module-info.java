module com.lumiere.lum {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens vue to javafx.fxml;
    exports vue;
}