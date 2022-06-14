package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.Customer;
import model.DataBaseModel;
import model.Person;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.Date;


public class RegistrationMember {
    SceneController sceneController;
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
        sceneController = new SceneController();
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
        errorDialogPane = new DialogPane();
    }

    @FXML
    private void handleContinueButtonAction(ActionEvent event) throws IOException {
        if(assertFields.isPhoneTextFieldValid(phoneNumberField.getText()) &&
                assertFields.isEmailAddressTextFieldValid(emailField.getText()))
        {
            Customer customer = new Customer(firstNameField.getText(), lastNameField.getText(),
                    emailField.getText(), Date.valueOf(dateOfBirthField.getValue()), passwordField.getText(), phoneNumberField.getText());
            dataBaseModel.insertClient(customer);
            sceneController.toLoggingMember(event);
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
