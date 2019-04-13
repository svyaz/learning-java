package com.github.svyaz.javalearning.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private final ProducerConsumerManager manager;

    Consumer(ProducerConsumerManager manager) {
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
                String item = manager.getItem();
                int randomValue = ThreadLocalRandom.current().nextInt(500, 1200);
                Thread.sleep(randomValue);
                System.out.println(item);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
