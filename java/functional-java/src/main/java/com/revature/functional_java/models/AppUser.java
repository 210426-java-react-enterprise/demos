package com.revature.functional_java.models;

import java.util.List;

public class AppUser {

    private String name;
    private String state;
    private int age;
    private List<String> skills;

    public AppUser(String name) {
        this.name = name;
    }

    public AppUser(String name, String state, int age, List<String> skills) {
        this.name = name;
        this.state = state;
        this.age = age;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }
}
