package com.revature.intro.screens;

import com.revature.intro.daos.UserDAO;
import com.revature.intro.models.AppUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegisterScreen {

    private BufferedReader consoleReader;

    public RegisterScreen(BufferedReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public void render() {

        String username;
        String password;
        String email;
        String firstName;
        String lastName;
        int age;

        try {
            System.out.println("Register an account");

            System.out.print("First Name: ");
            firstName = consoleReader.readLine();

            System.out.print("Last Name: ");
            lastName = consoleReader.readLine();

            System.out.print("Email: ");
            email = consoleReader.readLine();

            System.out.print("Username: ");
            username = consoleReader.readLine();

            System.out.print("Password: ");
            password = consoleReader.readLine();

            System.out.print("Age: ");
            age = Integer.parseInt(consoleReader.readLine());

            AppUser newUser = new AppUser(username, password, email, firstName, lastName, age);
            System.out.println(newUser.toString());
            UserDAO.saveUserToFile(newUser);

        } catch (NumberFormatException nfe) {
            System.err.println("Age has to be a number!");
            this.render();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
