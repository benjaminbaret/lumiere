package model;

import java.sql.Date;

/**
 * Guest class
 */
public class Guest extends Person {

    /**
     * @param firstName first name of the guest
     * @param lastName lase name of the guest
     * @param email email adress of the guest
     * @param dateOfBirth date birth of the guest
     */
    public Guest(String firstName, String lastName, String email, Date dateOfBirth) {

        super(firstName, lastName, email, dateOfBirth);

    }

}
