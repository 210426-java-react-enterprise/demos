package com.revature.intro.models;

/*
	Classes must be named the exact same as the file itself!

	Classes should (for best practice) be in PascalCase
		- not to be confused with camelCase

	POJO = Plain Old Java Object
		- Does not (usually) contain any methods beyond simple getters and setters
			+ maybe the occasional convenience method
 */

public class AppUser {

	private String username;
	private String password;
	private String email;
	private String fName;
	private String sName;
	private int age;

	public AppUser(String username, String password, String email, String fName, String sName, int age) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.fName = fName;
		this.sName = sName;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toFileString() {
		return String.format("%s;%s;%s;%s;%s;%d", username, password, email, fName, sName, age);
	}

	@Override
	public String toString() {
		return "AppUser{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", fName='" + fName + '\'' +
				", sName='" + sName + '\'' +
				", age=" + age +
				'}';
	}
}
