package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import model.Customer;
import model.DataBaseModel;

import java.io.IOException;
import java.sql.Date;


public class RegistrationMember {

    FXMLLoader loginMemberLoader;
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



    public RegistrationMember(){
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
        errorDialogPane = new DialogPane();
        loginMemberLoader = new FXMLLoader(getClass().getResource("login_page.fxml"));
    }

    @FXML
    private void handleContinueButtonAction(ActionEvent event) throws IOException {
        if(assertFields.isPhoneTextFieldValid(phoneNumberField.getText()) &&
                assertFields.isEmailAddressTextFieldValid(emailField.getText()))
        {
            Customer customer = new Customer(firstNameField.getText(), lastNameField.getText(),
                    emailField.getText(), Date.valueOf(dateOfBirthField.getValue()), passwordField.getText(), phoneNumberField.getText());
            dataBaseModel.insertClient(customer);

            FXMLLoader loginMemberLoader= new FXMLLoader(getClass().getResource("login_page.fxml"));
            Parent root = loginMemberLoader.load();
            LoginPage loginPage = loginMemberLoader.getController();
            loginPage.setLoginTitleText("Login member");
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            errorDialogPane.setVisible(true);
        }
    }

    @FXML
    private void okButtonClicked(ActionEvent event){
        errorDialogPane.setVisible(false);
    }

    @FXML
    private void quitButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader homeScreenLoader= new FXMLLoader(getClass().getResource("home_screen.fxml"));
        Parent root = homeScreenLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
