package com.revature.intro.models;

/*
 classes must be names the exact same as the file itself!

 class names should (for best practice) be Pascal Case

        -not to be confused with camelCase

        POJO = plain ol' Java Object
            -does not contain any methods beyond simple getters and setters
                + maybe the occasional convenience method
 */
public class AppUser {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;  // variables should be in camelCase
    private int age;


    public AppUser(String username, String password, String email, String firstName, String lastName, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getUsername(){
        //you do not have to include 'this', here because there is no other variable wit the same
        // name in the scope
        return username;
    }

    public void setUsername(String username){
        this.username = username;
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

    public String toFileString(){
        return String.format("%s, %s, %s, %s, %s, %d", username,password,email,firstName,lastName, age);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
