package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class ChoiceScreen {

    @FXML
    private Label helloLabel;

    public void setHelloLabel(String labelString){
        helloLabel.setText(labelString);
    }

    @FXML
    public void listMoviesButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader listMoviesLoader = new FXMLLoader(getClass().getResource("list_movies.fxml"));
        Parent root = listMoviesLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
