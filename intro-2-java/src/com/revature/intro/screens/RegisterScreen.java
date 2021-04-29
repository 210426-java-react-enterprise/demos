package com.revature.intro.screens;


import com.revature.intro.daos.UserDAO;
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
    private UserDAO  userDao = new UserDAO(); //GROSS! Change later...
    private BufferedReader consoleReader;

    public RegisterScreen(BufferedReader consoleReader){
        this.consoleReader = consoleReader;
    }

    public void render() {
        String fName = "";
        String lName = "";
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

            userDao.saveUserToFile(appUser);

            System.out.print(appUser.toString());

        } catch (NumberFormatException nfe) {
            // Specific
            this.fixInt(fName, lName);
        } catch (Exception e) {
            // General
            e.printStackTrace();
            System.out.println("GENERAL EXCEPTION"); // Should be logged in a prod environment not console
        }
    }

    public void render(String firstName, String lastName, int properAge) {
        String fName = firstName;
        String lName = lastName;
        String uName;
        String email;
        String password;

        int age = properAge;

        try {
            System.out.print("Email: ");
            email = consoleReader.readLine();

            System.out.print("Username: ");
            uName = consoleReader.readLine();

            System.out.print("Password: ");
            password = consoleReader.readLine();

            AppUser appUser = new AppUser(age, fName, lName, uName, password, email);

            userDao.saveUserToFile(appUser);

            System.out.print(appUser.toString());
            
        } catch (Exception e) {
            // General
            e.printStackTrace();
            System.out.println("GENERAL EXCEPTION"); // Should be logged in a prod environment not console
        }
    }

    public void fixInt(String firstName, String lastName) {
        int age;

        try {
            System.err.println("Please provide a proper age...");
            Thread.sleep(100);
            System.out.print("Age: ");
            age = Integer.parseInt(consoleReader.readLine());

            render(firstName, lastName, age);
        } catch (Exception e) {
            fixInt(firstName, lastName);
        }
    }
}
