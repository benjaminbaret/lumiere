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

public class ChoiceScreenAdmin {

    @FXML
    public Label emailLabel;


    /**
     * load the list movies page
     * @param event
     * @throws IOException
     */
    // load list movie page
    @FXML
    public void listMoviesButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader listMoviesLoader = new FXMLLoader(getClass().getResource("list_movies.fxml"));
        Parent root = listMoviesLoader.load();
        List_movies list_movies = listMoviesLoader.getController();
        list_movies.setIsEmployee(true);
        list_movies.setUserMailLabel(emailLabel.getText());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /** load the add movie page
     * @param event
     * @throws IOException
     */
    // load add movie page
    @FXML
    public void addMovieButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader addMovieLoader = new FXMLLoader(getClass().getResource("add_movie_one.fxml"));
        Parent root = addMovieLoader.load();
        AddMovie_one addMovie_oneController = addMovieLoader.getController();
        addMovie_oneController.setEmailEmployee(emailLabel.getText());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * load the add session page
     * @param event
     * @throws IOException
     */
    // load add session page
    @FXML
    public void addSessionButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader addSessionLoader = new FXMLLoader(getClass().getResource("add_session.fxml"));
        Parent root = addSessionLoader.load();
        AddSession addSessionController = addSessionLoader.getController();
        addSessionController.setEmailEmployee(emailLabel.getText());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setEmailLabel(String emailString){
        emailLabel.setText(emailString);
    }

    /**
     * load the home screen page
     * @param event
     * @throws IOException
     */
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
