package com.revature.intro;

import com.revature.intro.models.AppUser;
import com.revature.intro.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class driver {
    //type in main then tab
    public static void main(String[] args) {
        //serr tab
        System.out.println("Hello World!");

        //using AppUser
        AppUser newUser = new AppUser(
                "swekevin",
                "p@ssw0rd",
                "kevin.chang@revature.net",
                "Kevin",
                "Chang",
                23);
        System.out.printf("Hello and welcome, %s! \n", newUser.getUsername());
//        System.out.printf("%c", 'e');

        System.out.println(newUser.toFileString());

        //Moving the buffered reader here allows you to create more screens at once
        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            RegisterScreen newScreen = new RegisterScreen(consoleReader);
            newScreen.render();
        } catch (Exception e){
            e.printStackTrace();
        }
//        You can comment out statements quickly using Ctrl + /

    }


}
