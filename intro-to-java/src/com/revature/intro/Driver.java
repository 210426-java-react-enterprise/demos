package com.revature.intro;

import com.revature.intro.models.AppUser;
import com.revature.intro.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) {
//        AppUser user = new AppUser("vinsonchin", "P455w0rd",
//                                   "vinson.chin@revature.net",
//                                   "Vinson", "Chin", 8008);
//
//        System.out.printf("Welcome, %s! Your UserID is %d.", user.getUsername(), user.getAge());

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            RegisterScreen registerScreen = new RegisterScreen(consoleReader);
            registerScreen.render();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
