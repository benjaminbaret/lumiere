package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import model.DataBaseModel;
import model.Guest;
import model.Movie;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

public class BuyWithoutAccount {

    AssertFields assertFields;
    DataBaseModel dataBaseModel;

    @FXML
    private TextField FirstName_field;

    @FXML
    private TextField LastName_Field;

    @FXML
    private DatePicker birthDate_field;

    @FXML
    private TextField emailAdress_Field;

    public BuyWithoutAccount(){
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
    }

    @FXML
    private void addGuestButton(ActionEvent event) throws IOException {
        Guest guest = new Guest(FirstName_field.getText(), LastName_Field.getText(),
                emailAdress_Field.getText(), Date.valueOf(birthDate_field.getValue()));
        dataBaseModel.insertGuest(guest);
    }


}
