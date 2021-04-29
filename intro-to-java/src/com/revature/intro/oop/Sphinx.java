package com.revature.intro.oop;

public class Sphinx extends Cat {

    public Sphinx() {
        super();
    }

    @Override // not actually required, but good practice to include
    public void makeSound() {
        System.out.println("meow. (sphinx)");
    }
}
