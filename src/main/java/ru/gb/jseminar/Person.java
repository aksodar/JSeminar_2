package ru.gb.jseminar;

public class Person {
    private String firstname;
    private String secondName;

    public Person() {
    }
    public Person(String firstname, String secondName) {
        this.firstname = firstname;
        this.secondName = secondName;
    }
    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String name) {
        this.firstname = name;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
