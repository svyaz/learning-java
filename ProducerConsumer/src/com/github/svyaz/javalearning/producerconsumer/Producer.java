package com.github.svyaz.javalearning.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private final ProducerConsumerManager manager;

    Producer(ProducerConsumerManager manager) {
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
        int currentNumber = 1;

        while (true) {
            try {
                int randomValue = ThreadLocalRandom.current().nextInt(1000, 2000);
                Thread.sleep(randomValue);
                String threadName = Thread.currentThread().getName();
                manager.addItem(String.format("%s: Item-%d, ms worked: %d",
                        threadName,
                        currentNumber,
                        randomValue));
                currentNumber++;
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
