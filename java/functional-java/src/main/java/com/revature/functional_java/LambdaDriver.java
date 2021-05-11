package com.revature.functional_java;

import com.revature.functional_java.models.*;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaDriver {

    public static void main(String[] args) {
        /*
        Local anonymous classes

            - An inline implementation of a type (can be a concrete class, abstract class, or interface)
            - Creates another .class file at compilation

         */
        Animal newAnimal = new Animal() {
            @Override
            public void makeSound() {
                System.out.println("akjsfajerviaw");
            }
        };

        /*
            Functional interfaces

                - SAM: Single Abstract Method
                    + doesn't matter how many static or default methods it has

                - Inline implementations can be substituted with lambda expressions
         */

        System.out.println("The name of the thread running this statement is: " + Thread.currentThread().getName());
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("+------------------------+");
                System.out.println("The name of the thread running this statement is: " + Thread.currentThread().getName());
                System.out.println("This is a local anonymous class implementation of the Runnable interface!");
            }
        });
        t0.start();

        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        /*
            Lambda Expression

                - The inline implementation of a functional interface's one (and only) abstract method

                - Legal examples:
                    + (parameter) -> statement
                    + parameter -> statement
                    + parameter -> { code block of statements }
                    + (parameter, parameter) -> statement
                    + (parameter, parameter) -> { code block of statements }
                    + () -> expression
                    + () -> { code block of statements }

         */
        Thread t2 = new Thread(() -> {
            System.out.println("+------------------------+");
            System.out.println("The name of the thread running this statement is: " + Thread.currentThread().getName());
            System.out.println("This is a lambda expression implementation of the Runnable interface!");
        });
        t2.start();

        // Does not work, because the target of a lambda expression must be an interface
//        Animal wontWork = () -> {
//
//        };

        // Does not work, because Iterator is not a functional interface
//        Iterator<String> stringIterator = () -> {
//
//        };

        CustomRunnable customRunnable = () -> {
            System.out.println("+------------------------+");
            System.out.println("This is a lambda expression for my CustomRunnable interface, which is functional!");
        };
        customRunnable.run();

        // You must explicitly cast a lambda expression  to the desired type
        // if there is any ambiguity as to what type you are implementing inline
        CustomClass customClass = new CustomClass((Runnable) () -> {

        });

        CustomClass customClass2 = new CustomClass((CustomRunnable) () -> {

        });

        System.out.println("+------------------------+");

        List<String> associateNames = new ArrayList<>();
        associateNames.add("Nicholas");
        associateNames.add("Nick");
        associateNames.add("Kevin");
        associateNames.add("Sheckeem");
        associateNames.add("Ann");
        associateNames.add("EJ");
        associateNames.add("Bill");

        for (int i = 0; i < associateNames.size(); i++) {
            System.out.println(associateNames.get(i));
        }

        System.out.println("+------------------------+");
        for (String associateName : associateNames) {
            System.out.println(associateName);
        }

        System.out.println("+------------------------+");
        associateNames.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("+------------------------+");
        associateNames.forEach(associateName -> System.out.println(associateName));

        System.out.println("+------------------------+");
        associateNames.forEach(System.out::println);

        System.out.println("+------------------------+");
        List<String> namesStartingWithN = associateNames.stream()
                                                        .filter(name -> name.startsWith("N") || name.startsWith("n"))
                                                        .collect(Collectors.toList());

        namesStartingWithN.forEach(System.out::println);

        System.out.println("+------------------------+");
        List<AppUser> associates = associateNames.stream()
                                                 .map(AppUser::new)
                                                 .collect(Collectors.toList());

        associates.forEach(System.out::println);

        System.out.println("+------------------------+");
        List<AppUser> lameWay = new ArrayList<>();
        for (String name : associateNames) {
            lameWay.add(new AppUser(name));
        }
        for (AppUser u : lameWay) {
            System.out.println(u);
        }

        /*
            Marker interfaces

                - An interface with 0 method declarations.

                - Predates annotations

                - Common real world examples:
                    + Serializable
                    + Cloneable
                    + Remote

                - not commonly used anymore, but still some residual artifacts left over from
                  before we had annotations
         */



    }


}
