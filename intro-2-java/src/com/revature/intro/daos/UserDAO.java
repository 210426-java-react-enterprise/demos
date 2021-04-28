package com.revature.intro.daos;

import com.revature.intro.models.AppUser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 4/28/2021
 * Time: 4:35 PM
 * Description: {Insert Description}
 */
public class UserDAO
{
    public static void saveUserToFile(AppUser newUser) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Resources/users.txt", true))) {
            writer.write(newUser.toFileString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUserFromFile() {
        return "PLACEHOLDER";
    }
}
