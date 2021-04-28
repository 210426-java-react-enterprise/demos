package com.revature.intro.daos;

import com.revature.intro.models.AppUser;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class UserDAO {

    public static void saveUserToFile(AppUser newUser) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/users.txt", true))) {
            writer.write(newUser.toFileString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
