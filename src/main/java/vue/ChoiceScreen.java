package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoiceScreen {

    @FXML
    private Label emailLabel;

    public void setHelloLabel(String labelString){
        emailLabel.setText(labelString);
    }

    /**
     * load the list movies page
     * @param event
     * @throws IOException
     */
    @FXML
    public void listMoviesButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader listMoviesLoader = new FXMLLoader(getClass().getResource("list_movies.fxml"));
        Parent root = listMoviesLoader.load();
        List_movies list_movies = listMoviesLoader.getController();
        list_movies.setUserMailLabel(emailLabel.getText());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     }

    /**
     * load the quick booking page
     * @param event
     * @throws IOException
     */
    @FXML
    public void quickBookingButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader quickBookingLoader = new FXMLLoader(getClass().getResource("quick_booking.fxml"));
        Parent root = quickBookingLoader.load();
        QuickBooking quickBookingController = quickBookingLoader.getController();
        quickBookingController.setEmailLogged(emailLabel.getText());
        //filmResearch.setHelloLabel(emailTextField.getText()); --> Here to set the field for authentification
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * load the home screen page
     * @param event
     * @throws IOException
     */
    @FXML
    public void backToHomeScreen(ActionEvent event) throws IOException {
        FXMLLoader addMemberScreenLoader= new FXMLLoader(getClass().getResource("home_screen.fxml"));
        Parent root = addMemberScreenLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
