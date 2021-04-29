package com.revature.intro.screens;

import com.revature.intro.daos.UserDAO;
import com.revature.intro.models.AppUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegisterScreen {

    private  BufferedReader consoleReader;
    private UserDAO userDao = new UserDAO();

    public RegisterScreen(BufferedReader bufferedReader) {
        this.consoleReader = bufferedReader;
    }

    public void render() {
        String firstName;
        String lastName;
        String email;
        String username;
        String password;
        int age;

        try
        {
            System.out.println("Register for a new account!");
            System.out.println("+-------------------------+");

            System.out.println("First name: ");
            // get username
            firstName = consoleReader.readLine();

            System.out.println("Last name: ");
            // get lastname
            lastName = consoleReader.readLine();

            System.out.println("Email: ");
            // get email
            email = consoleReader.readLine();

            System.out.println("Username: ");
            // get username
            username = consoleReader.readLine();

            System.out.println("Password: ");
            // get password
            password = consoleReader.readLine();

            System.out.println("Age: ");
            // get age
            age = Integer.parseInt(consoleReader.readLine());

            AppUser newUser = new AppUser(username,password,email,firstName,lastName,age);
            userDao.saveUserToFile(newUser);
            System.out.println("New user created: " + newUser);

        } catch (NumberFormatException | IOException e) {
            System.err.println("\nBad age value entered!\n");
            e.printStackTrace();
            this.render();
        } catch (Exception e)
        {
            e.printStackTrace(); //we use this for development, for production we log to a file
        }



    }
}
