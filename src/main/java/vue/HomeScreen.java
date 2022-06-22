package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HomeScreen {

    //SceneController sceneController;

    public HomeScreen() {

    }

    public void loggingUserButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader loginMemberLoader= new FXMLLoader(getClass().getResource("login_page.fxml"));
        Parent root = loginMemberLoader.load();
        LoginPage loginPage = loginMemberLoader.getController();
        loginPage.setLoginTitleText("Login member");
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loggingEmployeeButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader loginMemberLoader= new FXMLLoader(getClass().getResource("login_page.fxml"));
        Parent root = loginMemberLoader.load();
        LoginPage loginPage = loginMemberLoader.getController();
        loginPage.setLoginTitleText("Login employee");
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addMemberButtonClicked(ActionEvent event) throws  IOException {
        FXMLLoader addMemberScreenLoader= new FXMLLoader(getClass().getResource("registration_member.fxml"));
        Parent root = addMemberScreenLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void buttonNoAccountClick(ActionEvent event) throws IOException {
        FXMLLoader choiceScreenLoader= new FXMLLoader(getClass().getResource("choice_screen.fxml"));
        Parent root = choiceScreenLoader.load();
        ChoiceScreen choiceScreen = choiceScreenLoader.getController();
        choiceScreen.setHelloLabel("No account");
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}