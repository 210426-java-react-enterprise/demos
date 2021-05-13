package com.revature.multithreaded_java.producer_consumer;

public class ProducerConsumerDriver {

    public static void main(String[] args) {

        final Object monitor = new Object();
        CustomBuffer buffer = new CustomBuffer();

        Producer producer = new Producer(buffer, monitor);
        Consumer consumer = new Consumer(buffer, monitor);

        Runnable producerTask = () -> {
            for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done producing!");
        };

        Runnable consumerTask = () -> {
            for (int i = 0; i < 50; i++) {
                consumer.consume();
            }
            System.out.println("Done consuming");
        };

        Thread producerThread = new Thread(producerTask);
        producerThread.setName("ProducerThread");

        Thread consumerThread = new Thread(consumerTask);
        consumerThread.setName("ConsumerThread");

        producerThread.setPriority(10);
        consumerThread.setPriority(10);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Data in the buffer: " + buffer.getCount());

    }

}
