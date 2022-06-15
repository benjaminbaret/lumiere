package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HomeScreen {

    SceneController sceneController;

    public HomeScreen() {
       sceneController = new SceneController();
    }

    public void loggingUserButtonClicked(ActionEvent event) throws IOException {
        sceneController.toLoggingMember(event);
    }

    public void loggingEmployeeButtonClicked(ActionEvent event) throws IOException {
       sceneController.toLoggingEmployee(event);
    }

}