module com.lumiere.lum {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jfxtras.controls;
    requires java.desktop;
    requires java.mail;


    opens vue to javafx.fxml;
    exports vue;
}