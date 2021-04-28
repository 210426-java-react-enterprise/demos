package com.revature.intro;

import com.revature.intro.models.AppUser;

public class Driver {

    public static void main(String[] args) {
        AppUser user = new AppUser("vinsonchin", "P455w0rd",
                                   "vinson.chin@revature.net",
                                   "Vinson", "Chin", 8008);

        System.out.printf("Welcome, %s! Your UserID is %d.", user.getUsername(), user.getId());

    }
}
