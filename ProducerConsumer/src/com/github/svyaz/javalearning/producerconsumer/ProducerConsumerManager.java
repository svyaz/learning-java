package com.github.svyaz.javalearning.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerManager {
    private final Queue<String> queue = new LinkedList<>();
    private final Object lock = new Object();
    private final static int CAPACITY = 5;
    private final static int PRODUCERS_COUNT = 2;
    private final static int CONSUMERS_COUNT = 2;

    /**
     * Creates and starts producers and consumers threads.
     */
    public void start() {
        for (int i = 0; i < PRODUCERS_COUNT; i++) {
            Thread producerThread = new Thread(new Producer(this));
            producerThread.setName("Producer-" + i);
            producerThread.start();
            System.out.println(producerThread.getName() + " started.");
        }
        for (int i = 0; i < CONSUMERS_COUNT; i++) {
            Thread consumerThread = new Thread(new Consumer(this));
            consumerThread.setName("Consumer-" + i);
            consumerThread.start();
            System.out.println(consumerThread.getName() + " started.");
        }
    }

    /**
     * Gets an item from the queue.
     *
     * @return item from the queue
     * @throws InterruptedException can be thrown.
     */
    String getItem() throws InterruptedException {
        synchronized (lock) {
            while (queue.size() == 0) {
                lock.wait();
            }
            String result = queue.remove();
            lock.notifyAll();
            return result;
        }
    }

    /**
     * Puts an item to the queue.
     *
     * @throws InterruptedException can be thrown.
     */
    void addItem(String item) throws InterruptedException {
        synchronized (lock) {
            while (queue.size() >= CAPACITY) {
                lock.wait();
            }
            queue.add(item);
            lock.notifyAll();
        }
    }
}
