package com.revature.intro;

import com.revature.intro.models.AppUser;

public class Driver {

    public static void main(String[] args) {
        AppUser newUser = new AppUser("Martin", "pass",
                "martin.tuck@revature.net", "Martin", "Tuck", 12);


        System.out.printf("Hello and welcome %s", newUser.getUsername());

    }
}
