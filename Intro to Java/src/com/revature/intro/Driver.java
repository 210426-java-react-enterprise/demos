package com.revature.intro;

// import com.revature.intro.models.AppUser;
import com.revature.intro.screens.Register;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {

    public static void main (String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Register registerScreen = new Register(reader);
            registerScreen.render();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
