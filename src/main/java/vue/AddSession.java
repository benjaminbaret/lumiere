package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import jfxtras.scene.control.LocalTimeTextField;
import model.DataBaseModel;

import java.io.IOException;

public class AddSession {

    AssertFields assertFields;
    DataBaseModel dataBaseModel;

    @FXML
    private Button buttonContinue;

    @FXML
    private Button buttonResetAll;

    @FXML
    private LocalTimeTextField endTime_field;

    @FXML
    private ComboBox<String> movieName_choice;

    @FXML
    private ComboBox<?> roomName_choice;

    @FXML
    private DatePicker sessionDate_field;

    @FXML
    private LocalTimeTextField startTime_field;

    public AddSession(){
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
    }

    @FXML
    private void printTitleMovie(ActionEvent event) throws IOException {
        for (int i = 0; i < dataBaseModel.selectTitleMovie().size(); i++) {
            System.out.println(dataBaseModel.selectTitleMovie().get(i));
        }
    }




}
