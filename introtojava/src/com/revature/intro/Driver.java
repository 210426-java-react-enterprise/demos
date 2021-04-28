package com.revature.intro;

import com.revature.intro.models.AppUser;

public class Driver {

    public static void main(String[] args) {

        AppUser user1 = new AppUser("staba", "p4ssw0rd", "sean.taba@revature.net", "Sean", "Taba", 21);

        System.out.printf("Hello and welcome, %s! I see that you are %d years old, nice!", user1.getUsername(), user1.getAge());
    }
}
