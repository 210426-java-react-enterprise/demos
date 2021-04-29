package com.revature.intro.model;

public class AppUser{

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private int age;

    public AppUser(String username, String password, String email, String firstName, String lastName, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toFileString() {
        return String.format("%s, %s, %s, %s, %s, %d", username, password, email, firstName, lastName, age);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AppUser{");
        sb.append("username=").append(username).append('\'');
        sb.append("password=").append(password).append('\'');
        sb.append("email=").append(email).append('\'');
        sb.append("firstName=").append(firstName).append('\'');
        sb.append("lastName=").append(lastName).append('\'');
        sb.append("age=").append(age).append('\'');
        return sb.toString();
    }
}
