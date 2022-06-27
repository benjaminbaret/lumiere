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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jfxtras.scene.control.LocalTimeTextField;
import model.DataBaseModel;
import model.Session;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
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

    public String emailEmployee;

    // constructor
    public AddSession(){
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
    }

    // initialize the window
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
        if (!(checkTimeDuration())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("TIME WRONG");
            alert.setContentText("START TIME MUST BE > THAT END TIME");
            alert.showAndWait();
            // checks if the date is after the current date
        } else if (checkDate()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("DATE WRONG");
            alert.setContentText("PLEASE SELECT A CORRECT DATE");
            alert.showAndWait();
        }
        else {
            Session session = new Session(movieName_choice.getValue(), roomName_choice.getValue(),
                    Date.valueOf(sessionDate_field.getValue()), Time.valueOf(startTime_field.getLocalTime()),
                    Time.valueOf(endTime_field.getLocalTime()));
            dataBaseModel.insertNewSession(session);

            // // display the window "Session added"
            sessionAdded.setVisible(true);
        }
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

    // a button that go to the choice screen admin
    @FXML
    public void backToChoiceAdmin(ActionEvent event) throws  IOException {
        FXMLLoader choiceScreenAdminLoader= new FXMLLoader(getClass().getResource("choice_screen_admin.fxml"));
        Parent root = choiceScreenAdminLoader.load();
        ChoiceScreenAdmin choiceScreenAdminController = choiceScreenAdminLoader.getController();
        choiceScreenAdminController.setEmailLabel(emailEmployee);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // [BOOLEAN] method that checks if the duration is correct, Start > End
    @FXML
    public boolean checkTimeDuration() {
        if (Time.valueOf(startTime_field.getLocalTime()).after(Time.valueOf(endTime_field.getLocalTime()))) {
            return false;
        }
        return true;
    }

    // [BOOLEAN] method that checks if the date is after the current date
    @FXML
    public boolean checkDate() {
        return ((Date.valueOf(sessionDate_field.getValue()).toLocalDate().isBefore((LocalDate.now()))));
    }

    public void setEmailEmployee(String email){
        emailEmployee = email;
    }

}
