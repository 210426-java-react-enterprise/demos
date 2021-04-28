package com.Revature.intro;

import com.Revature.intro.models.AppUser;

public class Driver {
    public static void main(String[] args) {
        AppUser newUser = new AppUser("chrislevano", "p4ssw0rd", "chrislevano@gmail.com", "Chris",
                "Levano", 22);
        System.out.printf("Hello %s! or would your rather Mr(s). %s?", newUser.getFirstName(), newUser.getLastName());
    }
}
