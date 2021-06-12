package com.revature.intro.oop;

import java.util.ArrayList;
import java.util.List;

public class OopDriver {

    public static void main(String[] args) {

        Animal ref = new Cat(10); // legal! covariance
        ref.makeSound();
        System.out.println(ref.numberOfLives); // 1

        Cat newRef = (Cat) ref;

        ref = new Dog();
        ref.makeSound();

//        Cat wontWork = new Animal(); // illegal! contravariance

        Cat sphinx = new Sphinx();
        System.out.println(sphinx.numberOfLives);
        sphinx.makeSound();
        sphinx.setCatNumberOfLives(9);

//        Object o = "hello";
//        String s = new Object();

        // widening
        int i1 = 5;
        long l = i1; // the value of i5 is widened to fit inside of long

        // narrowing
        long l2 = 123;
        int i2 = (int) l2; // the value of l2 is narrowed to fit within a n int

        // be careful!
        long l3 = 3_000_000_000L;
        int i3 = (int) l3;
        System.out.printf("Integer value range: %d to %d\n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(i3); // overflow! (avoid this!)
    }

}
