package vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainVue extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("add_movie_one.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("buy_without_account.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("seat.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("add_session.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("choice_screen_admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("BOUTON TEST!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}