package vue;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import model.Movie;

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
        Image img = new Image(getClass().getResourceAsStream(movie.getImageSource()));
        imageMovie.setImage(img);
        titleMovieField.setText(movie.getTitle());
        releaseDateField.setText(String.valueOf(movie.getReleaseDate()));
        directorMovieField.setText(movie.getDirector());
        realisatorMovieField.setText(movie.getRealisator());
        actorsMovieField.setText(movie.getActor());
        genreMovieField.setText(movie.getGenre());
        durationMovieField.setText("Duration :" + String.valueOf(movie.getDuration()));
        descriptionMovieField.setText(movie.getDescription());

    }

}
