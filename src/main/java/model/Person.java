package model;

import java.sql.Date;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;
    
    private Date dateOfBirth;

    // constructor
    public Person(String firstName, String lastName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    // return the firstName
    public String getFirstName() {
        return firstName;
    }

    // return the lastName
    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    @Override
    public String toString() {
        return "Person : " +
                "firstName = " + firstName +
                ", lastName = " + lastName;
    }
}
