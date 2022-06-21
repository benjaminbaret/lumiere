package vue;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import model.Movie;

import java.io.FileInputStream;
import java.io.InputStream;

public class MovieTemplate {

    @FXML
    private Label actorsMovieField;

    @FXML
    private HBox box;

    @FXML
    private Label descriptionMovieField;

    @FXML
    private Label directorMovieField;

    @FXML
    private Label durationMovieField;

    @FXML
    private Label genreMovieField;

    @FXML
    private ImageView imageMovie;

    @FXML
    private Label realisatorMovieField;

    @FXML
    private Label releaseDateField;

    @FXML
    private Label titleMovieField;

    public void setData(Movie movie) {

        Image image = new Image(movie.getImage());
        imageMovie.setImage(image);

        titleMovieField.setText(movie.getTitle());
        releaseDateField.setText("Release : " + movie.getReleaseDate());
        directorMovieField.setText("Director : " + movie.getDirector());
        realisatorMovieField.setText("Realisator : " + movie.getRealisator());
        actorsMovieField.setText("Actor : " + movie.getActor());
        genreMovieField.setText("Genre : " + movie.getGenre());
        durationMovieField.setText("Duration : " + movie.getDuration());
        descriptionMovieField.setText("Description : \n" + movie.getDescription());
    }

}
