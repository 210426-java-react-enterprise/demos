package com.revature.intro.models;
/*
    Classes must be named the exact same as the file

    Classes name should(for best practice) be in PascalCase
        -not to be confused with camelCase

    POJO = Plain Ol' Java Object
        mainly just getters and setters
 */
public class AppUser {

    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private int age;

    public AppUser(String userName, String password, String email, String firstName, String lastName, int age) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
