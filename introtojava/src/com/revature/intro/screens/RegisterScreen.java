package com.revature.intro.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegisterScreen {

    public void render() {
        String firstName;
        String lastName;
        String email;
        String username;
        String password;
        int age;

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

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
        } catch (NumberFormatException e) {
            System.err.println("Bad age value entered!");
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
