package vue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import model.DataBaseModel;

import java.awt.*;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmResearch {

    DataBaseModel dataBaseModel;
    @FXML
    private ComboBox filmChoiceBox;
    @FXML
    private ComboBox dateComboBox;
    @FXML
    private ComboBox timeComboBox;

    @FXML
    private void actionChoiceDoneFilm() throws SQLException {
        if(filmChoiceBox.getValue() != null){
            if (dateComboBox.getValue() == null) {
                dateComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("releaseDate", "title", filmChoiceBox.getValue().toString()));
            } else if (timeComboBox.getValue() == null) {
                timeComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("duration", "title", filmChoiceBox.getValue().toString()));
            }
        }
    }

    @FXML
    private void actionChoiceDoneTime() throws SQLException {
        if(timeComboBox.getValue() != null){
            if (filmChoiceBox.getValue() == null) {
                filmChoiceBox.setItems(dataBaseModel.getInformationsMoviesByColumn("title", "duration", timeComboBox.getValue().toString()));
            } else if (dateComboBox.getValue() == null) {
                dateComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("releaseDate", "duration", timeComboBox.getValue().toString()));
            }
        }
    }

    @FXML
    private void actionChoiceDoneDate() throws SQLException {
        if(dateComboBox.getValue() != null){
            if (filmChoiceBox.getValue() == null) {
                filmChoiceBox.setItems(dataBaseModel.getInformationsMoviesByColumn("title", "releaseDate", dateComboBox.getValue().toString()));
            } else if (timeComboBox.getValue() == null) {
                timeComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("duration", "releaseDate", dateComboBox.getValue().toString()));
            }
        }

    }

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

}
