package com.revature.multithreaded_java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDriver {

    public static void main(String[] args) {

        // create on-demand thread (very resource-intensive)
        Thread thread = new Thread(() -> {
            System.out.printf("%s says hello, world!\n", Thread.currentThread().getName());
//            return "someValue"; // does not work, Runnable#run has a void return type
//            throw new RuntimeException("Try and catch me, hahahahaha!"); // no other Thread can catch this!

        });

        try {
            thread.start();
        } catch (Exception e) {
            System.out.println("Exception caught and handled!"); // but it really wasn't
        }

        /*
            1. A thread is created on demand...by some developer working on the codebase.
            2. Once the task is complete, the thread is terminated/dies.
            3. Threads are expensive resources, and we should be able to reuse them if needed!
            4. Runnable#run has no return value and cannot raise exceptions.
         */

        /*
            Executor Pattern

                - aims to improve the use of thread resources
                    + by creating pools of ready-to-use threads
                    + Runnable tasks are given to existing threads in some pool
                    + threads remain in the pool even after the Runnable logic is complete

                - two required patterns:
                    + create a pool of threads
                    + pass a task to a thread within pool

               - Executor pattern:
                    executor.execute(task);

               - Runnable pattern:
                    new Thread(task)

         */

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Runnable task_1 = () -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("task_1 is running in %s\n", Thread.currentThread().getName());
        };
        Runnable task_2 = () -> System.out.printf("task_2 is running in %s\n", Thread.currentThread().getName());

        singleThreadExecutor.execute(task_1);
        singleThreadExecutor.execute(task_2);

        ExecutorService multiThreadExecutor = Executors.newFixedThreadPool(10);
        Runnable task_3 = () -> System.out.printf("task_3 is running in %s\n", Thread.currentThread().getName());
        Runnable task_4 = () -> System.out.printf("task_4 is running in %s\n", Thread.currentThread().getName());
        Runnable task_5 = () -> System.out.printf("task_5 is running in %s\n", Thread.currentThread().getName());
        Runnable task_6 = () -> System.out.printf("task_6 is running in %s\n", Thread.currentThread().getName());

        multiThreadExecutor.execute(task_2);
        multiThreadExecutor.execute(task_3);
        multiThreadExecutor.execute(task_4);
        multiThreadExecutor.execute(task_5);
        multiThreadExecutor.execute(task_6);

        /*
            It is necessary to invoke the ExecutorService#shutdown method, otherwise
            the JVM continues to run indefinitely because it will not end the app
            until all non-daemon threads are terminated.
         */

        try {
            singleThreadExecutor.shutdown();
            multiThreadExecutor.shutdown();
            while (!singleThreadExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Waiting for executor service to shutdown...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
}
