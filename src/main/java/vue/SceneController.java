package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    static LoginPage loginPage;
    static HomeScreen homeScreen;

    FXMLLoader loginMemberLoader;
    FXMLLoader homeScreenLoader;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public SceneController(){
        loginMemberLoader= new FXMLLoader(getClass().getResource("login_page.fxml"));
        homeScreenLoader= new FXMLLoader(getClass().getResource("home_screen.fxml"));
    }

    public void toLoggingMember(ActionEvent event) throws IOException {
        root = loginMemberLoader.load();
        loginPage = loginMemberLoader.getController();
        loginPage.setLoginTitleText("Login member");
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toLoggingEmployee(ActionEvent event) throws IOException {
        root = loginMemberLoader.load();
        loginPage = loginMemberLoader.getController();
        loginPage.setLoginTitleText("Login employee");
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toHomeScreen(ActionEvent event) throws IOException {
        root = homeScreenLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
