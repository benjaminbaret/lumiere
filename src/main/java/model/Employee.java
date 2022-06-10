package model;

public class Employee extends Person {
    private int idEmployee;

    public Employee(String firstName, String lastName, int age, String gender, int idEmployee) {
        super(firstName, lastName, age, gender);
        this.idEmployee = idEmployee;
    }

}
