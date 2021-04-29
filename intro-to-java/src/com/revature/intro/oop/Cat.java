package com.revature.intro.oop;

public class Cat extends Animal {

    // redeclaration of a variable in Animal
    // "shadowing"
    public int numberOfLives;

    public Cat() {
        numberOfLives = 9;
    }

    public Cat(int lives) {
        numberOfLives = lives;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow.");
    }

    public void setCatNumberOfLives(int newLives) {
        numberOfLives = newLives;
    }

}
