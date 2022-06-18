package model;

import javafx.scene.control.TextField;

import java.sql.*;

public class DataBaseModel {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lumierebdd";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String INSERT_QUERY = "INSERT INTO room (name, capacity) VALUES (?, ?)";
    private static final String INSERT_QUERY_CUSTOMER = "INSERT INTO `customer` (`firstName`, `lastName`, `dateOfBirth`, `email`, `password`, `phoneNumber`) VALUES (?, ?, ?, ?, ?, ?)";

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
}
