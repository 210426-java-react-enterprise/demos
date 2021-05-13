package com.revature.multithreaded_java.producer_consumer;

public class Consumer {

    private final Object monitor;
    private CustomBuffer buffer;

    public Consumer(CustomBuffer buffer, Object monitor) {
        this.monitor = monitor;
        this.buffer = buffer;
    }

    public void consume() {

        synchronized (monitor) {

            if (buffer.isEmpty()) {
                System.out.println("Buffer is empty, pausing consumer thread.");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            buffer.getBufferArray()[buffer.getCount() - 1] = 0;
            monitor.notify();
        }

    }

}
