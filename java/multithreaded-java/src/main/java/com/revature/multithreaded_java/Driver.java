package com.revature.multithreaded_java;

import com.revature.multithreaded_java.models.Deadlocker;

public class Driver {

    public static void main(String[] args) throws InterruptedException {

        Deadlocker deadlocker = new Deadlocker();

        Runnable r1 = deadlocker::methodA;
        Runnable r2 = deadlocker::methodB;

        Thread t1 = new Thread(r1);
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(r2);
        t2.setName("t2");
        t2.start();

        t1.join();
        t2.join();

    }
}
