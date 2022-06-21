package vue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import jfxtras.scene.control.LocalTimeTextField;
import model.DataBaseModel;
import model.Session;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddSession implements Initializable {

    AssertFields assertFields;
    DataBaseModel dataBaseModel;


    @FXML
    private BorderPane sessionAdded;

    @FXML
    private ComboBox<String> movieName_choice;

    @FXML
    private ComboBox<String> roomName_choice;

    @FXML
    private LocalTimeTextField endTime_field;

    @FXML
    private DatePicker sessionDate_field;

    @FXML
    private LocalTimeTextField startTime_field;

    public AddSession(){
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initialize ObservableList with the selectTitleMovie methode (which is an ArrayList)
        ObservableList<String> obListOfTitleMovie = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectTitleMovie()));
        // set items from obList
        movieName_choice.setItems(obListOfTitleMovie);

        // initialize ObservableList with the selectTitleMovie methode (which is an ArrayList)
        ObservableList<String> obListOfRoomName = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectRoomName()));
        // set items from obList
        roomName_choice.setItems(obListOfRoomName);
    }



    // add a session to the database
    @FXML
    private void addSessionButton(ActionEvent event) throws IOException {
        Session session = new Session(movieName_choice.getValue(), roomName_choice.getValue(),
                Date.valueOf(sessionDate_field.getValue()), Time.valueOf(startTime_field.getLocalTime()),
                Time.valueOf(endTime_field.getLocalTime()));
        dataBaseModel.insertNewSession(session);

        // // display the window "Session added"
        sessionAdded.setVisible(true);

    }

    // reset all the data fields
    @FXML
    private void resetButton(ActionEvent event) throws IOException {
        roomName_choice.valueProperty().setValue(null);
        movieName_choice.valueProperty().setValue(null);
        sessionDate_field.valueProperty().setValue(null);
        startTime_field.setLocalTime(null);
        endTime_field.setLocalTime(null);
    }

}
