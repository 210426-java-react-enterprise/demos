package com.revature.intro.class_loading;

public class Penguin extends Bird {

    // doesn't print, because we never
    // make any reference to this class
    static {
        System.out.println("p1");
    }

    {
        System.out.println("p2");
    }

    public static void foo() {
        System.out.println("foo");
    }
}
