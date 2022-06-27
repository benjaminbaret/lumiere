package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.DataBaseModel;
import model.Movie;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class List_movies implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private Label userMailLabel;

    private List<Movie> list_movie;

    private boolean isEmployee;

    AssertFields assertFields;
    DataBaseModel dataBaseModel;

    public List_movies() {
        isEmployee = false;
        assertFields = new AssertFields();
        dataBaseModel = new DataBaseModel();
    }

    // initialize the page
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list_movie = new ArrayList<>(list_movie());
        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i < list_movie.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("template_movie.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                if (column == 1) {
                    column = 0;
                    row++;
                }

                MovieTemplate movieTemplate = fxmlLoader.getController();
                movieTemplate.setData(list_movie.get(i));
                grid.add(anchorPane, column++, row);

                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // a method that store all the information of movies into a List
    private List<Movie> list_movie() {
        List<Movie> lm = new ArrayList<>();

        int size_arrayList = dataBaseModel.selectImageMovie().size();

        for (int i = 0; i< size_arrayList; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataBaseModel.selectImageMovie().get(i).getTitle());
            movie.setReleaseDate(dataBaseModel.selectImageMovie().get(i).getReleaseDate());
            movie.setDuration(dataBaseModel.selectImageMovie().get(i).getDuration());
            movie.setImage(dataBaseModel.selectImageMovie().get(i).getImage());
            movie.setDirector(dataBaseModel.selectImageMovie().get(i).getDirector());
            movie.setRealisator(dataBaseModel.selectImageMovie().get(i).getRealisator());
            movie.setGenre(dataBaseModel.selectImageMovie().get(i).getGenre());
            movie.setDescription(dataBaseModel.selectImageMovie().get(i).getDescription());
            movie.setActor(dataBaseModel.selectImageMovie().get(i).getActor());

            lm.add(movie);
        }

        return lm;
    }

    // load choice screen page
    public void backToHome(ActionEvent event) throws  IOException {
        if(isEmployee){
            FXMLLoader choiceScreenAdminLoader= new FXMLLoader(getClass().getResource("choice_screen_admin.fxml"));
            Parent root = choiceScreenAdminLoader.load();
            ChoiceScreenAdmin choiceScreenAdmin = choiceScreenAdminLoader.getController();
            choiceScreenAdmin.setEmailLabel(userMailLabel.getText());
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            FXMLLoader choiceScreenLoader= new FXMLLoader(getClass().getResource("choice_screen.fxml"));
            Parent root = choiceScreenLoader.load();
            ChoiceScreen choiceScreen = choiceScreenLoader.getController();
            choiceScreen.setHelloLabel(userMailLabel.getText());
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    public void setUserMailLabel(String userMailString){
        userMailLabel.setText(userMailString);
    }

    public void setIsEmployee(boolean state){
        isEmployee = state;
    }

}
