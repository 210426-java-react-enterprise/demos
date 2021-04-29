package com.revature.intro;

import com.revature.intro.daos.UserDAO;
import com.revature.intro.models.AppUser;
import com.revature.intro.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Driver {

    static UserDAO userDAO = new UserDAO();

    public static void main(String[] args) {

        AppUser user1 = new AppUser("staba", "p4ssw0rd", "sean.taba@revature.net", "Sean", "Taba", 21);

        System.out.printf("Hello and welcome, %s! I see that you are %d years old, nice!", user1.getUsername(), user1.getAge());
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            RegisterScreen registerScreen = new RegisterScreen(bufferedReader);
            registerScreen.render();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        List<AppUser> users = userDAO.loadUserProfile();
        for (AppUser user : users) {
            System.out.println(user);
        }
    }
}
