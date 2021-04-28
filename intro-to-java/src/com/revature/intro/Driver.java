package com.revature.intro;

import com.revature.intro.models.AppUser;
import com.revature.intro.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args){
      //  AppUser newUser = new AppUser("jmendoza","p4ssw0rd","jm@revature.net",
       //         "juan","mendoza", 25);
       // System.out.printf("Hello and welcome, %s!",newUser.getUsername());
       // System.out.printf("I see that you are %d years old!", newUser.getAge());
        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))){
            RegisterScreen registerScreen = new RegisterScreen(consoleReader);
            registerScreen.render();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}