package com.revature.intro.screens;

import com.revature.intro.daos.UserDAO;
import com.revature.intro.models.AppUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegisterScreen {

    private UserDAO userDao = new UserDAO(); //OK for now, but fix later
    private BufferedReader consoleReader;

    public RegisterScreen(BufferedReader consoleReader){
        this.consoleReader = consoleReader;
    }
    public void render(){
        System.out.println("Register for a new account!");
        System.out.println("+-------------------------+");

        String firstname;
        String lastName;
        String email;
        String username;
        String password;
        int age;

//        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //risky code that might throw an exception
            System.out.print("First Name: ");
            //get first name for user
            firstname = consoleReader.readLine();
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

            AppUser newUser = new AppUser(username, password, email, firstname, lastName, age);
            userDao.saveUserToFile(newUser);
        }catch (NumberFormatException nfe) {
            System.err.println("You provided an incorrect value for your age! Please use a number.");
            this.render();
        }catch (Exception e) {
            e.printStackTrace(); //include this line while developing & debugging the app!
            //should be logged to a file in a production environment
        }


    }
}
