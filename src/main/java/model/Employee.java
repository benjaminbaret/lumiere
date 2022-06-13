package model;

import java.sql.Date;

public class Employee extends Person {
    private int idEmployee;
    private String password;

    public Employee(String firstName, String lastName, String email, Date dateOfBirth, String password, int idEmployee) {
        super(firstName, lastName, email, dateOfBirth);
        this.idEmployee = idEmployee;
        this.password = password;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getPassword() {
        return password;
    }
}
