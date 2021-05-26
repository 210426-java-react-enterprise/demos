package com.revature.intro.class_loading;

public class Bird {

    // NON-STATIC/INSTANCE INITIALIZATION BLOCK
    // runs prior to any constructors
    // when an instance of this class
    // is instantiated
    {
        System.out.println("b1");
    }

    Bird() {
        System.out.println("b2");
    }


    // STATIC INITIALIZATION BLOCK
    // runs when the class is loaded
    // into JVM memory!
    static {
        System.out.println("b3");
    }

}
