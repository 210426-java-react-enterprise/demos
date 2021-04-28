package com.revature.intro;

import com.revature.intro.models.AppUser;
import com.revature.intro.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String args[]){
        //AppUser newUser = new AppUser("gtomasel", "p4ssw0rd", "e@mail.com", "Giancarlo", "Tomasello", 23);

        //System.out.printf("Hello and welcome, %s!", newUser.getUsername());

        //try (){} try with resources
        try(BufferedReader consoleReader = new BufferedReader((new InputStreamReader((System.in))))){
            RegisterScreen registerScreen = new RegisterScreen(consoleReader);
            registerScreen.render();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
