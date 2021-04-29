package com.revature.intro.screens;

import com.revature.intro.daos.UserDAO;
import com.revature.intro.model.AppUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegisterScreen {
    private UserDAO userDAO = new UserDAO();
    private BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public RegisterScreen(BufferedReader consoleReader){
        this.consoleReader = consoleReader;
    }
    public void render() {
        String firstName;
        String lastName;
        String email;
        String username;
        String password;
        int age;
        // ok but a little verbose
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        BufferedReader consoleReader = new BufferedReader(inputStreamReader);
        // better!

        try {
            // risky code that might through an exception
            System.out.println("Register for a new account!");
            System.out.println("+-------------------------+");
            System.out.print("First name: ");
            firstName = consoleReader.readLine(); // throws Exception here
            System.out.print("Last name: ");
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
            System.out.println("New user created: " + newUser);
        } catch (NumberFormatException nfe) {
            // do something about these!
            System.err.println("You provided an incorrect value for your age!");
            nfe.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace(); // include this line while developing/debugging the app!
            // should be logged to a file in a production environment
        }

    }

}
