package com.revature.intro.class_loading;

public class Hawk extends Raptor {

    static {
        System.out.println("h1");
    }

    // no explicitly declared constructor
    // the Java compiler will inject
    // a default no-args constructor
    // at compilation

    public static void main(String[] args) {
        System.out.println("init");

        // THEORY:
        // Apparently the JVM is smart enough to realize
        // that it doesn't need to load the Penguin
        // class into memory just because we made a declaration
        // of a Penguin variable (uninitialized).
        Penguin p;
        new Hawk();

        // This seems to force the JVM to actually load the Penguin
        // class into memory; executing its static blocks
        Penguin.foo();
        System.out.println("hawk");
    }

    // runs before main


}
