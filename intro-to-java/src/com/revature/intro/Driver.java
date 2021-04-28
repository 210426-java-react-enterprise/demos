package com.revature.intro;

import com.revature.intro.models.AppUser;

public class Driver {

    public static void main(String args[]){
        AppUser newUser = new AppUser("gtomasel", "p4ssw0rd", "e@mail.com", "Giancarlo", "Tomasello", 23);

        System.out.printf("Hello and welcome, %s!", newUser.getUsername());
    }
}
