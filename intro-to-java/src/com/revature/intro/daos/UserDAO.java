package com.revature.intro.daos;

import com.revature.intro.models.AppUser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class UserDAO {

    public void saveUserToFile(AppUser newUser){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("resources/users.txt", true))){
            writer.write(newUser.toFileString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AppUser findUserByUsername(String username){
        return null;
    }
}
