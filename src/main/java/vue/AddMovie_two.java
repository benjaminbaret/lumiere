package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AddMovie_two {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button movieUploadImage_button;

    private Button buttonBackMovie;

    @FXML
    private void uploadImage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        File f = fc.showOpenDialog(null);
    }

    @FXML
    private void previousPage(ActionEvent event)throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("add_movie_one.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
