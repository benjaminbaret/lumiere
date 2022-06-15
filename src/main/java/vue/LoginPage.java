package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.DataBaseModel;

import java.io.IOException;

public class LoginPage {

    SceneController sceneController;
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
        sceneController = new SceneController();

    }

    @FXML
    private void handleContinueButtonAction(ActionEvent event){
        if(dataBaseModel.authenticateClient(emailTextField.getText(), passwordTextField.getText())){
            authentificationFailedLabel.setVisible(false);
        } else{
            authentificationFailedLabel.setVisible(true);
        }
    }

    @FXML
    private void handleResetButtonClicked(ActionEvent event){
        emailTextField.setText("");
        passwordTextField.setText("");
    }

    @FXML
    private void exitButtonClicked(ActionEvent event) throws IOException {
       sceneController.toHomeScreen(event);
    }

    public void setLoginTitleText(String loginString){
        loginTitleText.setText(loginString);
        System.out.println(loginString);
    }
}



