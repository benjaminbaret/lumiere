package vue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.DataBaseModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FilmResearch implements Initializable {

    AssertFields assertFields;
    DataBaseModel dataBaseModel;
    @FXML
    private ComboBox<String> filmChoiceBox;
    @FXML
    private ComboBox<String> dateComboBox;
    @FXML
    private ComboBox<String> timeComboBox;

    public FilmResearch(){
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
    }

    /**
     * initialize the page
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initialize ObservableList with the selectTitleMovie methode (which is an ArrayList)
        ObservableList<String> obListOfTitleMovie = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectTitleMovieFromSession()));
        // set items from obList
        filmChoiceBox.setItems(obListOfTitleMovie);
    }

    /**
     * set the time of the movie into timeComboBox
     */
    @FXML
    private void actionChoiceDoneTime() {
        if (dateComboBox.getValue() != null) {
            ObservableList<String> obListOfSessionTime = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectSessionTime(filmChoiceBox.getValue())));
            timeComboBox.setItems(obListOfSessionTime);
        }
    }

    /**
     * set the date of the movie into dateComboBox
     */
    @FXML
    private void actionChoiceDoneDate() {
        if (timeComboBox.getValue() == null) {
            ObservableList<String> obListOfSessionDate = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectSessionDate(filmChoiceBox.getValue())));
            dateComboBox.setItems(obListOfSessionDate);
        }
    }

    /**
     * reset all the fields
     * @throws SQLException
     */
    @FXML
    private void buttonEraseClicked() throws SQLException {
        for(int i=0; i< filmChoiceBox.getItems().size(); i++){
            filmChoiceBox.getItems().remove(i);
        }
        for(int i=0; i< dateComboBox.getItems().size(); i++){
            dateComboBox.getItems().remove(i);
        }
        for(int i=0; i< timeComboBox.getItems().size(); i++){
            timeComboBox.getItems().remove(i);
        }
        filmChoiceBox.setItems(dataBaseModel.getInformationsMoviesByColumn("title"));
        dateComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("releaseDate"));
        timeComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("duration"));
    }

    @FXML
    private void initialize() throws SQLException {
        dataBaseModel = new DataBaseModel();
        filmChoiceBox.setItems(dataBaseModel.getInformationsMoviesByColumn("title"));
        dateComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("releaseDate"));
        timeComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("duration"));
    }

    @FXML
    private void validateButtonClicked(){
        //

    }

    /**
     * load the choice screen page
     * @param event
     * @throws IOException
     */
    @FXML
    private void backToChoiceButton(ActionEvent event) throws IOException {
        FXMLLoader addMemberScreenLoader= new FXMLLoader(getClass().getResource("choice_screen.fxml"));
        Parent root = addMemberScreenLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
