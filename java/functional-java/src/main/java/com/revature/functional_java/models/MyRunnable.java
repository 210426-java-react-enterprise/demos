package com.revature.functional_java.models;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("+------------------------+");
        System.out.println("The name of the thread running this statement is: " + Thread.currentThread().getName());
        System.out.println("This is an explicitly declared implementation of the Runnable interface!");
    }
}
