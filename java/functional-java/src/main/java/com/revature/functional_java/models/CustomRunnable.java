package com.revature.functional_java.models;

import java.util.function.Supplier;

// really just used for compilation errors to ensure this interface is actually a functional one
@FunctionalInterface
public interface CustomRunnable<T> extends Supplier<T> {

    void run();

//    void foo(); not allowed because we declared this interface as functional

    default void bar() {

    }

    static void baz() {

    }


    // technically, we can add more abstract method stubs and it still be a valid
    // functional interfaces; so long as the other abstract methods are implemented
    // by Object
    boolean equals(Object o);
    int hashCode();

    // you can inherit from other interfaces in a functional interface, so long as you
    // provide a default implementation for them
    @Override
    default T get() {
        return null;
    }
}
