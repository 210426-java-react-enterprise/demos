package com.revature.intro.screens;

import com.revature.intro.daos.UserDAO;
import com.revature.intro.models.AppUser;

import java.io.BufferedReader;
import java.io.IOException;

public class Register{

    private BufferedReader inputRead;
    private UserDAO userDAO = new UserDAO();

    public Register(BufferedReader b) {
        inputRead = b;

    }

    public void render() {

        String username;
        String email;
        String password;
        String firstName;
        String lastName;
        int age;

        try {
            System.out.println("Register for a new account!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.print("Username:");
            username = inputRead.readLine();

            System.out.print("Email:");
            email = inputRead.readLine();

            System.out.print("Password:");
            password = inputRead.readLine();

            System.out.print("First Name:");
            firstName = inputRead.readLine();

            System.out.print("Last Name:");
            lastName = inputRead.readLine();

            System.out.print("Age:");
            age = Integer.parseInt(inputRead.readLine());

            AppUser newUser = new AppUser(username, email, password, firstName, lastName, age);
            userDAO.saveUserToFile(newUser);
        } catch (NumberFormatException | IOException nfe) {
            System.err.println("Invalid value for age. Please try again.");
            this.render();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
