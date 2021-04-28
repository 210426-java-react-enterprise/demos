package com.revature.intro.screens;

import com.revature.intro.daos.UserDAO;
import com.revature.intro.models.AppUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegisterScreen {

	private UserDAO userDao = new UserDAO(); // okay for now, fix later
	private BufferedReader consoleReader;

	public RegisterScreen (BufferedReader consoleReader) {
		this.consoleReader = consoleReader;
	}

	public void render() {
		String username;
		String password;
		String email;
		String fName;
		String sName;
		int age;

		// BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

		try {
			// risky code that might throw an exception
			System.out.println("Register for a new account!");
			System.out.println("+-------------------------+");

			System.out.println("First name: ");
			fName = consoleReader.readLine();

			System.out.println("Last name: ");
			sName = consoleReader.readLine();

			System.out.println("Email: ");
			email = consoleReader.readLine();

			System.out.println("Username: ");
			username = consoleReader.readLine();

			System.out.println("Password: ");
			password = consoleReader.readLine();

			System.out.println("Age: ");
			age = Integer.parseInt(consoleReader.readLine());

			AppUser newUser = new AppUser(username, password, email, fName, sName, age);
			userDao.saveUserToFile(newUser);

			// System.out.println(newUser.toFileString());
			// System.out.println("New user created: " + newUser);

		} catch (NumberFormatException e ) {
			System.err.println("You provided an incorrect value for your age! Please try again!");
			this.render();
		} catch (Exception e) {
			// handle the exception
		}

	}
}
