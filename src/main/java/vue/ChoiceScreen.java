package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
        List_movies list_movies = listMoviesLoader.getController();
        list_movies.setUserMailLabel(helloLabel.getText());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML void quickBookingButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader filmeSearchLoader = new FXMLLoader(getClass().getResource("film_research.fxml"));
        Parent root = filmeSearchLoader.load();
        FilmResearch filmResearch = filmeSearchLoader.getController();
        //filmResearch.setHelloLabel(emailTextField.getText()); --> Here to set the field for authentification
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
