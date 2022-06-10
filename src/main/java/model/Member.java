package model;

public class Member extends Customer {

    private String username;
    private String password;
    private int point;
    private String emailAdress;
    private int id;

    public Member(String firstName, String lastName, int age, String gender) {
        super(firstName, lastName, age, gender);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPoint() {
        return point;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public int getId() {
        return id;
    }
}
