package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.Customer;
import model.DataBaseModel;
import model.Person;
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

    @FXML 
    private void handleContinueButtonAction(ActionEvent event) {
        if(assertFields.isPhoneTextFieldValid(phoneNumberField.getText()) &&
                assertFields.isEmailAddressTextFieldValid(emailField.getText()))
        {
            Customer customer = new Customer(firstNameField.getText(), lastNameField.getText(),
                    emailField.getText(), Date.valueOf(dateOfBirthField.getValue()), passwordField.getText(), phoneNumberField.getText());
            dataBaseModel.insertClient(customer);
        }
        else{
            errorDialogPane.setVisible(true);
        }
    }

    @FXML 
    private void okButtonClicked(ActionEvent event){
        errorDialogPane.setVisible(false);
    }



}
