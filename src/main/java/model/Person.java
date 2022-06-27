package model;

import java.sql.Date;

/**
 * Abstract class Person which defines the basic fields of a person
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;
    
    private Date dateOfBirth;

    /**
     * @param firstName first name of a person
     * @param lastName lasr name of a person
     * @param email email adress of a person
     * @param dateOfBirth date of birth of a person
     */
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
