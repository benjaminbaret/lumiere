package vue;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMovie_one {

    private Stage stage;
    private Scene scene;

    ObservableList<String> genreListMove = FXCollections.observableArrayList("Drama","Thriller","Romantic");

    @FXML
    private ChoiceBox movieGenre_choice;

    @FXML
    private TextField movieName_field, movieDuration_field, movieRealisator_field, movieDirector_field;
    @FXML
    private DatePicker movieDate_field;


    @FXML
    private void initialize() {
        movieGenre_choice.setItems(genreListMove);
    }
    @FXML
    private void nextPage(ActionEvent event)throws IOException {
        if(movieName_field.getText().isBlank() || movieDuration_field.getText().isBlank() || movieRealisator_field.getText().isBlank() || movieDirector_field.getText().isBlank() || movieDate_field.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REQUIRED");
            alert.setContentText("ALL FIELD MUST ARE REQUIRED");
            alert.showAndWait();
        }
        else {
            Parent root=FXMLLoader.load(getClass().getResource("add_movie_two.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
