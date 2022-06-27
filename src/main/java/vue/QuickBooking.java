package vue;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.DataBaseModel;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class QuickBooking extends Application implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private Button payButton;

    @FXML
    private ComboBox<String> filmChoiceBox;
    @FXML
    private ComboBox<String> dateComboBox;
    @FXML
    private ComboBox<String> timeComboBox;
    @FXML
    private ComboBox<String> numberPlace;

    @FXML
    private BorderPane secondPage;
    @FXML
    private BorderPane thirdPage;
    @FXML
    private BorderPane fourthPage;
    @FXML
    private BorderPane fifthPage;

    @FXML
    private Label dateConfirmation;
    @FXML
    private Label movieConfirmation;
    @FXML
    private Label timeConfirmation;
    @FXML
    private Label numberOfTicketConfirmation;

    @FXML
    private TextField cardNumberField;

    @FXML
    private TextField mounthCardField;

    @FXML
    private TextField yearMounthCard;

    @FXML
    private TextField securityCodeField;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField emailAdress;

    @FXML
    private Label priceTicket;

    private final ObservableList<String> numberOfPlace = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8");

    int count;

    public String emailLogged;
    AssertFields assertFields;
    DataBaseModel dataBaseModel;

    public QuickBooking() {
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
    }

    @Override
    public void start(Stage stage) throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slideshow();
        // initialize ObservableList with the selectTitleMovie methode (which is an ArrayList)
        ObservableList<String> obListOfTitleMovie = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectTitleMovieFromSession()));
        // set items from obList
        filmChoiceBox.setItems(obListOfTitleMovie);
        numberPlace.setItems(numberOfPlace);
    }

    @FXML
    private void initialize() throws SQLException {
        dataBaseModel = new DataBaseModel();
        filmChoiceBox.setItems(dataBaseModel.getInformationsMoviesByColumn("title"));
        dateComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("releaseDate"));
        timeComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("duration"));
    }

    public void slideshow() {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("C:\\Users\\benja\\IdeaProjects\\lum\\src\\main\\resources\\img\\interstellar-slide.jpg"));
        images.add(new Image("C:\\Users\\benja\\IdeaProjects\\lum\\src\\main\\resources\\img\\star-wars-slide.jpg"));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            imageView.setImage(images.get(count));
            count++;
            if (count == images.size()) count = 0;
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void actionChoiceDoneTime() {
        if (dateComboBox.getValue() != null) {
            ObservableList<String> obListOfSessionTime = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectSessionTime(filmChoiceBox.getValue())));
            timeComboBox.setItems(obListOfSessionTime);
        }
    }

    @FXML
    private void actionChoiceDoneDate() {
        if (timeComboBox.getValue() == null) {
            ObservableList<String> obListOfSessionDate = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectSessionDate(filmChoiceBox.getValue())));
            dateComboBox.setItems(obListOfSessionDate);
        }
    }

    @FXML
    private void actionChoiceDoneFilm(){
        for (int i = 0; i < dateComboBox.getItems().size(); i++) {
            dateComboBox.getItems().remove(i);
        }
        for (int i = 0; i < timeComboBox.getItems().size(); i++) {
            timeComboBox.getItems().remove(i);
        }
        ObservableList<String> obListOfSessionDate = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectSessionDate(filmChoiceBox.getValue())));
        ObservableList<String> obListOfSessionTime = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectSessionTime(filmChoiceBox.getValue())));
        dateComboBox.setItems(obListOfSessionDate);
        timeComboBox.setItems(obListOfSessionTime);

        dateComboBox.setPromptText("Session date");
        timeComboBox.setPromptText("Duration");
    }

    @FXML
    private void buttonEraseClicked() throws SQLException {
        for (int i = 0; i < filmChoiceBox.getItems().size(); i++) {
            filmChoiceBox.getItems().remove(i);
        }
        for (int i = 0; i < dateComboBox.getItems().size(); i++) {
            dateComboBox.getItems().remove(i);
        }
        for (int i = 0; i < timeComboBox.getItems().size(); i++) {
            timeComboBox.getItems().remove(i);
        }
        ObservableList<String> obListOfTitleMovie = FXCollections.observableList(new ArrayList<>(dataBaseModel.selectTitleMovieFromSession()));
        dateComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("releaseDate"));
        timeComboBox.setItems(dataBaseModel.getInformationsMoviesByColumn("duration"));
        filmChoiceBox.setItems(obListOfTitleMovie);
        numberPlace.setItems(numberOfPlace);
    }

    @FXML
    private void backToChoiceButton(ActionEvent event) throws IOException {
        FXMLLoader choiceScreenLoader = new FXMLLoader(getClass().getResource("choice_screen.fxml"));
        Parent root = choiceScreenLoader.load();
        ChoiceScreen choiceScreenController = choiceScreenLoader.getController();
        choiceScreenController.setHelloLabel(emailLogged);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void quickBookButton(ActionEvent event) {

        if (filmChoiceBox.getValue() == null || dateComboBox.getValue() == null
                || timeComboBox.getValue() == null || numberPlace.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REQUIRED");
            alert.setContentText("ALL FIELD MUST ARE REQUIRED");
            alert.showAndWait();
        } else if (filmChoiceBox.getValue() != null && dateComboBox.getValue() != null
                && timeComboBox.getValue() != null && numberPlace.getValue() != null) {

            String roomName = dataBaseModel.selectRoomNameSession(filmChoiceBox.getValue(), dateComboBox.getValue());
            int place_session = dataBaseModel.selectNumberPlaceSession(filmChoiceBox.getValue(), roomName, Date.valueOf(dateComboBox.getValue()));


            if (Integer.parseInt(numberPlace.getValue()) + place_session > 50){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SORRY BUT TOO MUCH PLACE");
                alert.setContentText("SORRY BUT THE SESSION IS ALMOST COMPLETE, IT LEFT " + (50 - place_session) + "PLACES !");
                alert.showAndWait();
            }
            else {
                secondPage.setVisible(true);
                movieConfirmation.setText("Movie : " + filmChoiceBox.getValue());
                dateConfirmation.setText("Date : " + dateComboBox.getValue());
                timeConfirmation.setText("Time : " + timeComboBox.getValue());
                numberOfTicketConfirmation.setText("Number of place : " + numberPlace.getValue());
                if(!Objects.equals(emailLogged, "No account")){
                    priceTicket.setText("Price : 7£");
                }else{
                    priceTicket.setText("Price : 10£");
                }

                if (!Objects.equals(emailLogged, "No account")) {
                    firstName.setText(dataBaseModel.getFirstName(emailLogged));
                    lastName.setText(dataBaseModel.getLastName(emailLogged));
                    emailAdress.setText(emailLogged);
                }
            }
        }
    }

    @FXML
    private void confirmButton(ActionEvent event) {
        if(assertFields.isEmailAddressTextFieldValid(emailAdress.getText()) && !Objects.equals(firstName.getText(), "") && !Objects.equals(lastName.getText(), "")){
            thirdPage.setVisible(true);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PLEASE ANSWER WITH GOOD INFORMATIONS");
            alert.setContentText("Make sure that email is type : email@example.com");
            alert.showAndWait();
        }
    }

    @FXML
    private void backToQuickBooking(ActionEvent event) {
        secondPage.setVisible(false);
    }

    @FXML
    private void backButtonPaiment(ActionEvent event) {
        thirdPage.setVisible(false);
        secondPage.setVisible(true);
    }

    @FXML
    private void confirmationDone(ActionEvent event) throws Exception  {
        String roomName = dataBaseModel.selectRoomNameSession(filmChoiceBox.getValue(), dateComboBox.getValue());

        if (assertFields.isCardCodeValid(cardNumberField.getText()) &&
                assertFields.isMounthValid(mounthCardField.getText()) &&
                assertFields.isYearValid(yearMounthCard.getText()) &&
                assertFields.isSecurityCodeValid(securityCodeField.getText())
        ) {
            PauseTransition wait = new PauseTransition(Duration.seconds(3));
            fourthPage.setVisible(true);
            wait.setOnFinished((e) -> {
                fifthPage.setVisible(true);
            });
            wait.play();
            dataBaseModel.updatePlaceSession(filmChoiceBox.getValue(),roomName,dateComboBox.getValue(), Integer.parseInt(numberPlace.getValue()));
            MailSender.sendMail(emailAdress.getText(), firstName.getText(), filmChoiceBox.getValue(),
                    roomName,dateComboBox.getValue(), timeComboBox.getValue(), numberPlace.getValue());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WRONG NUMBER");
            alert.setContentText("PLEASE ENTER CORRECT FORMAT");
            alert.showAndWait();
        }
    }

    @FXML
    private void paymentConfirmation() {
        fourthPage.setVisible(true);
    }

    public void setEmailLogged(String email) {
        emailLogged = email;
    }
}
