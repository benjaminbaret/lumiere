package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class ChoiceScreenAdmin {

    @FXML
    public Label emailLabel;


    // load list movie page
    @FXML
    public void listMoviesButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader listMoviesLoader = new FXMLLoader(getClass().getResource("list_movies.fxml"));
        Parent root = listMoviesLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // load add movie page
    @FXML
    public void addMovieButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader addMovieButtton = new FXMLLoader(getClass().getResource("add_movie_one.fxml"));
        Parent root = addMovieButtton.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // load add session page
    @FXML
    public void addSessionButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader addSessionButton = new FXMLLoader(getClass().getResource("add_session.fxml"));
        Parent root = addSessionButton.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setEmailLabel(String emailString){
        emailLabel.setText(emailString);
    }

    @FXML
    public void backToHomeScreen(ActionEvent event) throws IOException {
        FXMLLoader addMemberScreenLoader= new FXMLLoader(getClass().getResource("home_screen.fxml"));
        Parent root = addMemberScreenLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
