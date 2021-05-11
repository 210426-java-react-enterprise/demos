package com.revature.functional_java.models;

// really just used for compilation errors to ensure this interface is actually a functional one
@FunctionalInterface
public interface CustomRunnable {

    void run();
//    void foo(); not allowed because we declared this interface as functional

    default void bar() {

    }

    static void baz() {

    }
}
