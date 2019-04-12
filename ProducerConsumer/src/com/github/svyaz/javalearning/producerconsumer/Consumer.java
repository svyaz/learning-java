package com.github.svyaz.javalearning.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private final ProducerConsumerManager manager;

    public Consumer(ProducerConsumerManager manager) {
        this.manager = manager;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            try {
                manager.getItem();
                int randomValue = ThreadLocalRandom.current().nextInt(1000, 2000);
                Thread.sleep(randomValue);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
