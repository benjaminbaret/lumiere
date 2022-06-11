package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.DataBaseModel;


public class VueFXML {
    @FXML
    private TextField room_name;

    @FXML
    private TextField capacity;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {

            // get room_name
            String nameRoom = room_name.getText();

            // get capacity room
            int capacityRoom = Integer.parseInt(capacity.getText());

            DataBaseModel data_base = new DataBaseModel();
            data_base.insertRoom(nameRoom, capacityRoom);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}