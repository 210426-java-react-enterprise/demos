package com.revature.intro.screens;


import com.revature.intro.models.AppUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 4/28/2021
 * Time: 2:41 PM
 * Description: {Insert Description}
 */
public class RegisterScreen {
    BufferedReader consoleReader;

    public RegisterScreen(BufferedReader consoleReader){
        this.consoleReader = consoleReader;
    }

    public void render() {
        String fName;
        String lName;
        String uName;
        String email;
        String password;

        int age;

        try {
            System.out.println("Register for a new account.");
            System.out.println("+-------------------------+");

            System.out.print("First name: ");
            fName = consoleReader.readLine();

            System.out.print("Last name: ");
            lName = consoleReader.readLine();

            System.out.print("Age: ");
            age = Integer.parseInt(consoleReader.readLine());

            System.out.print("Email: ");
            email = consoleReader.readLine();

            System.out.print("Username: ");
            uName = consoleReader.readLine();

            System.out.print("Password: ");
            password = consoleReader.readLine();

            AppUser appUser = new AppUser(age, fName, lName, uName, password, email);

            System.out.print(appUser.toString());

        } catch (NumberFormatException nfe) {
            // Specific
            System.err.println("Please provide a proper age...");
            this.render();
        } catch (Exception e) {
            // General
            e.printStackTrace();
            System.out.println("GENERAL EXCEPTION"); // Should be logged in a prod environment not console
        }
    }
}
