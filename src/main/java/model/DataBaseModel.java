package model;

import javafx.scene.control.TextField;

import java.sql.*;

public class DataBaseModel {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lumierebdd";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "root";
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

}
