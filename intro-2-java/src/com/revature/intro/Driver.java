package com.revature.intro;

import com.revature.intro.models.AppUser;
import com.revature.intro.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 4/28/2021
 * Time: 11:36 AM
 * Description: {Insert Description}
 */
public class Driver {

    public static void main(String[] args) {
        /*
        AppUser newUser = new AppUser(27, "James", "Bialon",
                                "James.Bialon", "FakePassword",
                                "James.Bialon@revature.net");

        System.out.printf("Username: %s\n", newUser.getuName());
        */

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            RegisterScreen console = new RegisterScreen(consoleReader);
            console.render();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
