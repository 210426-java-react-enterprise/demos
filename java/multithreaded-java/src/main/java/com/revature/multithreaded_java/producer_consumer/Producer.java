package com.revature.multithreaded_java.producer_consumer;

public class Producer {

    private final Object monitor;
    private CustomBuffer buffer;

    public Producer(CustomBuffer buffer, Object monitor) {
        this.monitor = monitor;
        this.buffer = buffer;
    }

    public void produce() {

        synchronized (monitor) {

            if (buffer.isFull()) {
                System.out.println("Buffer full, pausing producer thread.");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            buffer.getBufferArray()[buffer.getCount()] = 1;
            buffer.incrementCount();

            System.out.println("Produced new value! Notifying monitor.");
            monitor.notify();

        }
    }
}
