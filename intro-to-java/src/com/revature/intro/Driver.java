package com.revature.intro;
import com.revature.intro.models.AppUser;

public class Driver {
    public static void main(String[] args){
        AppUser newUser = new AppUser("wsingleton", "p@ssW0rd",
                "wezley.singleton@revature.com", "Wezley",
                "Singleton", 30);

        System.out.printf("Hello and welcome, %s!", newUser.getUsername());
    }
}
