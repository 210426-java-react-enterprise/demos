package com.revature.intro;

import com.revature.intro.model.AppUser;
import com.revature.intro.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Driver {

    public static void main (String[] args) {
        AppUser user = new AppUser("fight4justice", "p4$$w0rd", "kumqwat@gmail.com", "Kathy", "Jones", 41);
        System.out.printf("Hello and welcome, %s!", user.getUsername());

        BufferedReader consoleReader = new BufferedReader((new InputStreamReader(System.in)));
        RegisterScreen newScreen = new RegisterScreen(consoleReader);
        newScreen.render();
    }

}
