package com.revature.intro.daos;

import com.revature.intro.models.AppUser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserDAO {

	public void saveUserToFile(AppUser newUser) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("resources/users.txt", true))) {
			writer.write(newUser.toFileString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AppUser findUserByUsername(String username) {
		// will finish another time.
		return null;
	}
}
