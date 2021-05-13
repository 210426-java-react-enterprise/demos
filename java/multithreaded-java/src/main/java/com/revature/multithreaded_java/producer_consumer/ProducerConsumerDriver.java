package com.revature.multithreaded_java.producer_consumer;

public class ProducerConsumerDriver {

    public static void main(String[] args) {

        final Object monitor = new Object();
        CustomBuffer buffer = new CustomBuffer();

        Thread producerThread = new Thread(producerTask);
        producerThread.setName("ProducerThread");

        Thread consumerThread = new Thread(consumerTask);
        consumerThread.setName("ConsumerThread");

        producerThread.setPriority(3);
        consumerThread.setPriority(10);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
