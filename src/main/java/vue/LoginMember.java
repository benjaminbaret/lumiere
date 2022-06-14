package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.DataBaseModel;

public class LoginMember {

    DataBaseModel dataBaseModel;
    @FXML
    TextField emailTextField;
    @FXML
    PasswordField passwordTextField;

    @FXML
    private Label authentificationFailedLabel;

    public LoginMember(){
        dataBaseModel = new DataBaseModel();
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
}



