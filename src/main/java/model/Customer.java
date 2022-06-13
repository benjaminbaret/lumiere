package model;

import java.sql.Date;

public class Customer extends Person {

    private String password;
    private String phoneNumber;
    
    public Customer(String firstName, String lastName, String email, Date dateOfBirth, String password, String phoneNumber) {
        super(firstName, lastName, email, dateOfBirth);
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    } 
    
    public String getPhoneNumber() {
        return phoneNumber;
    }


}
