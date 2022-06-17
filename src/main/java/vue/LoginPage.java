package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.DataBaseModel;

import java.io.IOException;


public class LoginPage {

    private DataBaseModel dataBaseModel;

    @FXML
    private Text loginTitleText;

    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label authentificationFailedLabel;

    public LoginPage(){
        dataBaseModel = new DataBaseModel();
    }

    @FXML
    private void handleContinueButtonAction(ActionEvent event) throws IOException {
        if(loginTitleText.getText().equals("Login member")){
            if(dataBaseModel.authenticateClient(emailTextField.getText(), passwordTextField.getText())){
                FXMLLoader choiceScreenLoader= new FXMLLoader(getClass().getResource("choice_screen.fxml"));
                Parent root = choiceScreenLoader.load();
                ChoiceScreen choiceScreen = choiceScreenLoader.getController();
                choiceScreen.setHelloLabel(emailTextField.getText());
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                authentificationFailedLabel.setVisible(false);
            } else{
                authentificationFailedLabel.setVisible(true);
            }
        }
        else{
            if(dataBaseModel.authenticateEmployee(emailTextField.getText(), passwordTextField.getText())){
                authentificationFailedLabel.setVisible(false);
            } else{
                authentificationFailedLabel.setVisible(true);
            }
        }
    }

    @FXML
    private void handleResetButtonClicked(ActionEvent event){
        emailTextField.setText("");
        passwordTextField.setText("");
    }

    @FXML
    private void exitButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader homeScreenLoader= new FXMLLoader(getClass().getResource("home_screen.fxml"));
        Parent root = homeScreenLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setLoginTitleText(String loginString){
        loginTitleText.setText(loginString);
        System.out.println(loginString);
    }
}



