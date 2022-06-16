package vue;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import model.DataBaseModel;
import model.Movie;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class List_movies implements Initializable {

    @FXML
    private ImageView image_one;
    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;

    private List<Movie> list_movie;

    AssertFields assertFields;
    DataBaseModel dataBaseModel;

    public List_movies() {
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
    }

    private List<Movie> list_movie() {
        List<Movie> lm = new ArrayList<>();
        Movie movie = new Movie();
        movie.setTitle("Dunkerque");
        movie.setImageSource("/img/dunkerque-cover.jpg");
        lm.add(movie);

        movie = new Movie();
        movie.setTitle("Interstellar");
        movie.setImageSource("/img/interstellar-cover.jpg");
        lm.add(movie);

        movie = new Movie();
        movie.setTitle("Toy Story");
        movie.setImageSource("/img/toy-story-cover.jpg");
        lm.add(movie);

        movie = new Movie();
        movie.setTitle("Afram 4");
        movie.setImageSource("/img/pdp_4.png");
        lm.add(movie);

        movie = new Movie();
        movie.setTitle("Afram 5");
        movie.setImageSource("/img/pdp_5.png");
        lm.add(movie);

        return lm;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list_movie = new ArrayList<>(list_movie());
        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i < list_movie.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("template_movie.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                if (column == 1) {
                    column = 0;
                    row++;
                }

                MovieTemplate movieTemplate = fxmlLoader.getController();
                movieTemplate.setData(list_movie.get(i));
                grid.add(anchorPane, column++, row);

                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
