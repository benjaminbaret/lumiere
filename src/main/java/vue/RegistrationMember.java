package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.DataBaseModel;
import org.w3c.dom.Text;

import java.sql.Date;


public class RegistrationMember {
    AssertFields assertFields;
    DataBaseModel dataBaseModel;

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private DatePicker dateOfBirthField;

    @FXML
    private DialogPane errorDialogPane;

    @FXML
    private Button okDialogButton;

    public RegistrationMember(){
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
        errorDialogPane = new DialogPane();
    }

    @FXML protected void handleContinueButtonAction(ActionEvent event) {
        if(assertFields.isPhoneTextFieldValid(phoneNumberField.getText()) &&
                assertFields.isEmailAddressTextFieldValid(emailField.getText()))
        {
            dataBaseModel.insertClient(firstNameField.getText(), lastNameField.getText(),
                    emailField.getText(), passwordField.getText(), phoneNumberField.getText(), Date.valueOf(dateOfBirthField.getValue()));
        }
        else{
            errorDialogPane.setVisible(true);
        }
    }

    @FXML protected void okButtonClicked(ActionEvent event){
        errorDialogPane.setVisible(false);
    }



}
