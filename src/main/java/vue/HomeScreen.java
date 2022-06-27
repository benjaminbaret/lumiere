package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Class that allows to interact with the home menu (the first menu)
 */
public class HomeScreen {

    /**
     * constructor by default
     */
    public HomeScreen() {
    }

    /**
     * load the login page for customer when the user click on the login user button
     * @param event
     * @throws IOException
     * @return void
     */
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

    /**
     * load the login page for employee when the user click on the login member button
     * @param event
     * @throws IOException
     */
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

    /**
     * load the registration page when the user click on the registration button
     * @param event
     * @throws IOException
     * @return void
     */
    public void addMemberButtonClicked(ActionEvent event) throws  IOException {
        FXMLLoader addMemberScreenLoader= new FXMLLoader(getClass().getResource("registration_member.fxml"));
        Parent root = addMemberScreenLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * load the choice screen page when the user click on the "buy without account button"
     * @param event
     * @throws IOException
     * @return void
     */
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