package vue;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMovie_one {

    private Stage stage;
    private Scene scene;

    ObservableList<String> genreListMove = FXCollections.observableArrayList("Drama","Thriller","Romantic");

    @FXML
    private ChoiceBox movieGenre_choice;

    @FXML
    private Button buttonContinue;

    @FXML
    private void initialize() {
        movieGenre_choice.setItems(genreListMove);
    }
    @FXML
    private void nextPage(ActionEvent event)throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("add_movie_two.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
