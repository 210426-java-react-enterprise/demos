package com.revature.intro;

import com.revature.intro.models.AppUser;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello, IntelliJ!");

        AppUser newUser = new AppUser("man",
                "pw",
                "man@me.com",
                "First",
                "Last",
                0);


        System.out.printf("Hello and welcome, %s! I see that you are %d years old, nice!", newUser.getUsername(), newUser.getAge());
    }
}