package com.revature.intro;

import com.revature.intro.models.AppUser;

public class Driver {

    public static void main(String[] args) {
        AppUser newUser = new AppUser("wsingleton", "p4ssw0rd",
                                      "wezley.singleton@revature.com",
                                      "Wezley", "Singleton", 30);

        System.out.printf("Hello and welcome, %s! I see that you are %d years old, nice!", newUser.getUsername(), newUser.getAge());

        // doesn't work because %d only works with digits
//        System.out.printf("Test char with digit specifier: %d", 'a');
    }

}
