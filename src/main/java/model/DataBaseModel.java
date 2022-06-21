package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseModel {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lumierebdd";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String INSERT_QUERY = "INSERT INTO room (name, capacity) VALUES (?, ?)";
    private static final String INSERT_QUERY_CUSTOMER = "INSERT INTO `customer` (`firstName`, `lastName`, `birthDate`, `email`, `password`, `phoneNumber`) VALUES (?, ?, ?, ?, ?, ?)";

    public void insertRoom(String room_name, int capacity) {

        // Establishing a Connection
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, room_name);
            preparedStatement.setInt(2, capacity);
            System.out.println(preparedStatement);

            // Execute the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertClient(Customer customer){

        // Establishing a Connection
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_CUSTOMER);
            //preparedStatement.setString(1, "NULL");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setDate(3, customer.getDateOfBirth());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getPassword());
            preparedStatement.setString(6, customer.getPhoneNumber());

            // Execute the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertNewMovie(Movie movie) {
        String INSERT_QUERY_MOVIE = "INSERT INTO `movie` (`title`, `releaseDate`, `duration`, `image`, `director`, `realisator`, `genre`, `description`, `actor`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_MOVIE);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setDate(2, movie.getReleaseDate());
            preparedStatement.setTime(3, movie.getDuration());
            preparedStatement.setBinaryStream(4, movie.getImage());
            preparedStatement.setString(5, movie.getDirector());
            preparedStatement.setString(6, movie.getRealisator());
            preparedStatement.setString(7, movie.getGenre());
            preparedStatement.setString(8, movie.getDescription());
            preparedStatement.setString(9, movie.getActor());

            // Execute the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // return a ArrayList which contains all the movies information
    public ArrayList<Movie> selectImageMovie() {
        // An ArrayList which contains a list of arraylist
        ArrayList<Movie> list_movies = new ArrayList<>();

        Movie my_movie;

        String SELECT_IMAGE_QUERY_MOVIE = "SELECT * FROM movie;";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_IMAGE_QUERY_MOVIE);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                my_movie = new Movie();
                my_movie.setTitle(rs.getString(2));
                my_movie.setReleaseDate(rs.getDate(3));
                my_movie.setDuration(rs.getTime(4));

                my_movie.setImage(rs.getBinaryStream(5));

                my_movie.setDirector(rs.getString(6));
                my_movie.setRealisator(rs.getString(7));
                my_movie.setGenre(rs.getString(8));
                my_movie.setDescription(rs.getString(9));
                my_movie.setActor(rs.getString(10));
                list_movies.add(my_movie);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list_movies;
    }

    // select all the title from the movie
    public ArrayList<String> selectTitleMovie() {
        ArrayList<String> list_title_movies = new ArrayList<>();

        String SELECT_TITLE_QUERY_MOVIE = "SELECT title FROM movie;";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TITLE_QUERY_MOVIE);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                list_title_movies.add(rs.getString(1));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list_title_movies;
    }

    // select all the title from the movie
    public ArrayList<String> selectRoomName() {
        ArrayList<String> list_room_name = new ArrayList<>();

        // The query
        String SELECT_TITLE_QUERY_MOVIE = "SELECT name FROM room;";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TITLE_QUERY_MOVIE);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                // put the result of the query into the ArrayList
                list_room_name.add(rs.getString(1));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list_room_name;
    }

    public void insertNewSession(Session session) {
        String INSERT_QUERY_MOVIE = "INSERT INTO `session` (`movieTitle`, `roomName`, `sessionDate`, `startTime`, `endTime`) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_MOVIE);
            preparedStatement.setString(1, session.getMovieTitle());
            preparedStatement.setString(2, session.getRoomName());
            preparedStatement.setDate(3, session.getSessionDate());
            preparedStatement.setTime(4, session.getStartTime());
            preparedStatement.setTime(5, session.getEndTime());

            // Execute the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertGuest(Guest guest){
        String INSERT_QUERY_GUEST = "INSERT INTO `guest` (`firstName`, `lastName`, `birthDate`, `email`) VALUES (?, ?, ?, ?)";


        // Establishing a Connection
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_GUEST);
            preparedStatement.setString(1, guest.getFirstName());
            preparedStatement.setString(2, guest.getLastName());
            preparedStatement.setDate(3, guest.getDateOfBirth());
            preparedStatement.setString(4, guest.getEmail());

            // Execute the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public boolean authenticateClient(String email, String password){
        String SQL_QUERY = "SELECT * FROM `customer` WHERE email = '"+ email + "' AND password = '"+ password + "';";
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareCall(SQL_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
       return false;
    }
    public boolean authenticateEmployee(String email, String password){
        String SQL_QUERY = "SELECT * FROM `employee` WHERE email = '"+ email + "' AND password = '"+ password + "';";
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareCall(SQL_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
       return false;
    }

    public ObservableList<String> getInformationsMoviesByColumn(String columnLabel) throws SQLException {
        String SQL_QUERY = "SELECT * FROM `movie` ";
        ArrayList<String> newArrar = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                newArrar.add(rs.getString(columnLabel));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return FXCollections.observableArrayList(newArrar);
    }


    public ObservableList<String> getInformationsMoviesByColumn(String columnLabel, String columnSelected, String parameterChoosed) throws SQLException {
        String SQL_QUERY = "SELECT * FROM `movie` WHERE " + columnSelected + " = '" + parameterChoosed + "';";
        ArrayList<String> newArrar = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                newArrar.add(rs.getString(columnLabel));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return FXCollections.observableArrayList(newArrar);
    }
}
