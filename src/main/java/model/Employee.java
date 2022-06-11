package model;

public class Employee extends Person {
    private int idEmployee;
    private String username;
    private String password;

    public Employee(String firstName, String lastName, int age, String gender, int idEmployee, String username, String password) {
        super(firstName, lastName, age, gender);
        this.idEmployee = idEmployee;
        this.username = username;
        this.password = password;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
