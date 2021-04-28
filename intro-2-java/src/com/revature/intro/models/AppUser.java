package com.revature.intro.models;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 4/28/2021
 * Time: 11:46 AM
 * Description: {Insert Description}
 */
public class AppUser {
    private int uAge;
    private String fName;
    private String lName;
    private String uName;
    private String uPass;
    private String uEmail;

    public AppUser(){
        this.uAge = 21;
        this.fName = "First";
        this.lName = "Last";
        this.uName = "Username";
        this.uPass = "Password";
        this.uEmail = "E-Mail";
    }

    public AppUser(int uAge, String fName, String lName, String uName, String uPass,String uEmail){
        this.uAge = uAge;
        this.fName = fName;
        this.lName = lName;
        this.uName = uName;
        this.uPass = uPass;
        this.uEmail = uEmail;
    }

    public int getuAge() {
        return uAge;
    }

    public void setuAge(int uAge) {
        this.uAge = uAge;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }
}
