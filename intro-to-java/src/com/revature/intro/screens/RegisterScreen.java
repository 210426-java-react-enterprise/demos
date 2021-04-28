package com.revature.intro.screens;

import com.revature.intro.daos.UserDAO;
import com.revature.intro.models.AppUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class RegisterScreen {
    private UserDAO userDao = new UserDAO(); //okay for now but actually gross!!
    private BufferedReader consoleReader;
    public RegisterScreen(BufferedReader consoleReader){
        this.consoleReader = consoleReader;
    }
    public void render(){
        String firstName;
        String lastName;
        String username;
        String email;
        String password;
        int age;


        try{

            //okay but little verbose
            //InputStreamReader  inputStreamReader = new InputStreamReader(System.in);
            //BufferedReader consoleReader = new BufferedReader(inputStreamReader);

            //better!


            //risky code
            System.out.println("Register for a new account.");
            System.out.println("+--------------------------+.");

            System.out.println("First Name:");
            firstName = consoleReader.readLine();
            //get first name from user

            System.out.println("Last Name");
            //get last name
            lastName = consoleReader.readLine();

            System.out.println("Email");
            //get email from user
            email = consoleReader.readLine();

            System.out.println("Username");
            //get username from user
            username = consoleReader.readLine();

            System.out.println("Age");
            //get age from user
            age = Integer.parseInt(consoleReader.readLine());

            System.out.println("Password");
            //get password from user
            password = consoleReader.readLine();

            AppUser newUser = new AppUser(username, password, email, firstName,lastName,age);
            userDao.saveUserToFile(newUser);
            System.out.println("New User Created:" + newUser);


        }catch(NumberFormatException | IOException e){
                //catching something
            System.err.println("You provided an illegal form of number!! Try again!");
            e.printStackTrace();

        }catch (Exception e){
            //do something about it
            e.printStackTrace();//include this line while developing/debugging this app
            //should be logged to a file in a production environment
        }


    }

}
