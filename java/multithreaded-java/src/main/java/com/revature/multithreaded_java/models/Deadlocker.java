package com.revature.multithreaded_java.models;

public class Deadlocker {

    private final Object monitorA = new Object();
    private final Object monitorB = new Object();
    private final Object monitorC = new Object();

    public void methodA() {
        synchronized (monitorA) {
            System.out.printf("[%s] is running inside of methodA()\n", Thread.currentThread().getName());
            methodB();
        }
    }

    public void methodB() {
        synchronized (monitorB) {
            System.out.printf("[%s] is running inside of methodB()\n", Thread.currentThread().getName());
            methodC();
        }
    }

    public void methodC() {
        synchronized (monitorC) {
            System.out.printf("[%s] is running inside of methodC()\n", Thread.currentThread().getName());
        }
    }
}
