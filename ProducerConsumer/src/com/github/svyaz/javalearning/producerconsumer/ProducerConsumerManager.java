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
            Thread producer = new Thread(new Producer(this));
            producer.setName("Producer-" + i);
            producer.start();
        }
        for (int i = 0; i < CONSUMERS_COUNT; i++) {
            Thread consumer = new Thread(new Consumer(this));
            consumer.setName("Consumer-" + i);
            consumer.start();
        }
    }

    /**
     * Gets an item from the queue.
     *
     * @return item from the queue
     * @throws InterruptedException
     */
    public String getItem() throws InterruptedException {
        synchronized (lock) {
            while (queue.size() < CAPACITY) {
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
     * @throws InterruptedException
     */
    public void addItem(String item) throws InterruptedException {
        synchronized (lock) {
            while (queue.size() >= CAPACITY) {
                lock.wait();
            }
            queue.add(item);
            lock.notifyAll();
        }
    }
}
