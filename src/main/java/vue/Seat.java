package vue;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class Seat {

    @FXML
    private ImageView A1;

    @FXML
    private void selectSeat(MouseEvent e) {
        System.out.println(A1.getImage().getUrl());
        if (A1.getImage().getUrl().equals("file:/C:/Users/afram/IdeaProjects/lumiere/src/main/resources/img/chair-black.png")) {
            File file = new File("src/main/resources/img/chair.png");
            Image image = new Image(file.toURI().toString());
            A1.setImage(image);
        }
        else {
            File file = new File("src/main/resources/img/chair-black.png");
            Image image = new Image(file.toURI().toString());
            A1.setImage(image);
        }
    }

}
