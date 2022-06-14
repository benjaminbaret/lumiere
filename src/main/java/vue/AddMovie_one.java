package vue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javafx.stage.FileChooser;
import jfxtras.scene.control.LocalTimeTextField;
import model.DataBaseModel;
import model.Movie;

public class AddMovie_one {

    // all the movie genres
    ObservableList<String> genreListMove = FXCollections.observableArrayList("Drama","Thriller","Romantic");
    @FXML
    //genre of the movie
    private ChoiceBox movieGenre_choice;
    @FXML
    //title of the movie
    private TextField movieName_field;
    @FXML
    //duration of the movie
    private LocalTimeTextField movieDuration_field;
    @FXML
    //realisator of the movie
    private TextField movieRealisator_field;
    @FXML
    //director of the movie
    private TextField movieDirector_field;
    @FXML
    //release date of the movie
    private DatePicker movieDate_field;

    @FXML
    // actor of the film
    private TextField actorsField;
    @FXML
    //image view of the movie
    private ImageView viewImageLoad;

    @FXML
    // description of the film
    private TextArea descriptionField;

    @FXML
    private BorderPane secondWindow;

    @FXML
    private BorderPane thirdWindow;

    AssertFields assertFields;
    DataBaseModel dataBaseModel;

    // image of the movie
    private FileInputStream imageMovie;

    public AddMovie_one() {
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
    }

    @FXML
    private void initialize() {
        movieGenre_choice.setItems(genreListMove);
    }

    @FXML
    private void nextPage(ActionEvent event) throws IOException {
        // can access to the next page only if all the fields are OK
        if(movieName_field.getText().isBlank() || movieDate_field.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REQUIRED");
            alert.setContentText("ALL FIELD MUST ARE REQUIRED");
            alert.showAndWait();
        }
        else {
            // display the next screen
            secondWindow.setVisible(true);
        }
    }

    @FXML
    private void previousPage(ActionEvent event) throws IOException {
        secondWindow.setVisible(false);
    }

    @FXML
    private void uploadImage(ActionEvent event) throws IOException {
        FileChooser fc =new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        File f = fc.showOpenDialog(null);
        FileInputStream fileInputStream = new FileInputStream(f);
        Image image = new Image(fileInputStream);
        viewImageLoad.setImage(image);
        this.imageMovie = fileInputStream;
    }

    @FXML
    private void addMovieButton(ActionEvent event) throws IOException{
        Movie movie = new Movie(movieName_field.getText(), movieDirector_field.getText(),
                movieRealisator_field.getText(), movieGenre_choice.getValue().toString(),
                actorsField.getText(), Date.valueOf(movieDate_field.getValue()),
                imageMovie, Time.valueOf(movieDuration_field.getLocalTime()),
                descriptionField.getText());
        dataBaseModel.insertNewMovie(movie);

        // display the window "the movie has been added"
        thirdWindow.setVisible(true);
    }

}
