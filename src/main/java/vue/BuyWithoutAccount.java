package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.DataBaseModel;
import model.Guest;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

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

    /**
     * add the guest into the database
     * @param event
     * @throws IOException
     */
    @FXML
    private void addGuestButton(ActionEvent event) throws IOException {
        // check if the person is major
        if (checkMajorPerson()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("YOU ARE MINOR");
            alert.setContentText("YOU MUST BE OLDER THAN 18 TO BUY");
            alert.showAndWait();
        // check if the email adress is correct
        } else if (!(assertFields.isEmailAddressTextFieldValid(emailAdress_Field.getText()))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("EMAIL INCORRECT");
            alert.setContentText("EMAIL INCORRECT");
            alert.showAndWait();
        } else {
            Guest guest = new Guest(FirstName_field.getText(), LastName_Field.getText(),
                    emailAdress_Field.getText(), Date.valueOf(birthDate_field.getValue()));
            dataBaseModel.insertGuest(guest);
        }
    }

    /**
     * check if the user is major
     * @return boolean
     */
    // method that checks if the buyer is > 18
    @FXML
    private boolean checkMajorPerson() {
        int majority = LocalDate.now().getDayOfYear();
        if ((majority - birthDate_field.getValue().getDayOfYear() < 18))  {
            return false;
        }
        return true;
    }


}
