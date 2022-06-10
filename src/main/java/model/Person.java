package model;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    // constructor
    public Person(String firstName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    // return the firstName
    public String getFirstName() {
        return firstName;
    }

    // return the lastName
    public String getLastName() {
        return lastName;
    }

    // return the age
    public int getAge() {
        return age;
    }

    // return the gender
    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person : " +
                "firstName = " + firstName +
                ", lastName = " + lastName +
                ", age = " + age +
                ", gender = " + gender;
    }
}
