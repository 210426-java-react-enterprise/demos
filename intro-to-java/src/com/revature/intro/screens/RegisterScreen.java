package com.revature.intro.screens;

import com.revature.intro.daos.UserDAO;
import com.revature.intro.models.AppUser;

import java.io.BufferedReader;

// POJO: Plain Old Java Object

public class RegisterScreen {

    private UserDAO userDao = new UserDAO(); // ok for now, but actually gross -- fix later
    private BufferedReader consoleReader; // may be 'final'?

    public RegisterScreen(BufferedReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public void render(){
        String username;
        String password;
        String email;
        String firstName;
        String lastName;
        int age;


        /*
        Buffered readers are good for parsing string.
        Scanner is better for parsing different primitive types.
         */

        //ok, but a little verbose
        //InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        //BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        //better
        //BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            //risky code that might throw an exception
            System.out.println("Register for a new account!");
            System.out.println("+----------------------------------+");

            System.out.println("First name: ");
            firstName = consoleReader.readLine(); // throws exception here

            System.out.println("Last name: ");
            lastName = consoleReader.readLine();

            System.out.println("Email: ");
            email = consoleReader.readLine();

            System.out.println("Age: ");
            //age = consoleReader.readLine(); //doesn't work
            age = Integer.parseInt(consoleReader.readLine());

            System.out.println("Username: ");
            username = consoleReader.readLine();

            System.out.println("Password: ");
            password = consoleReader.readLine();

            AppUser newUser = new AppUser(username, password, email, firstName, lastName, age);
            userDao.saveUserToFile(newUser);

        } catch (NumberFormatException nfe){
            //if caught, do something about these!
            nfe.printStackTrace();//could be problematic if user continually inputs invalid int for "age"
        } catch (Exception e){
            e.printStackTrace(); // include this line while developing/debugging the app!
            // should be logged to a file in a production environment (as opposed to console)
            //don't use outside of a production environment (use alternative)
        }
    }

    public void verifyInt(){

    }
}
