package com.revature.intro;

import com.revature.intro.models.AppUser;

public class Driver {
    public static void main(String[] args) {

        System.out.println("Hello, IntelliJ!");
        AppUser newUser = new AppUser("jfallon", "password", "jfallon432@gmail.com", "James", "Fallon", 28 );
        System.out.printf("Hello and welcome, %s! I see that you are %d years old!", newUser.getUserName(), newUser.getAge());
    }
}
