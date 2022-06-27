package model;

import java.sql.Date;

public class Customer extends Guest {

    private String password;
    private String phoneNumber;

    /**
     * @param firstName first name of the customer
     * @param lastName lasr name of the customer
     * @param email email adress of the customer
     * @param dateOfBirth date of birth of the customer
     * @param password password of the customer
     * @param phoneNumber phone number of the customer
     */
    public Customer(String firstName, String lastName, String email, Date dateOfBirth, String password, String phoneNumber) {
        super(firstName, lastName, email, dateOfBirth);
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    /**
     * return the password
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * return the phoneNumber
     * @return String
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


}
