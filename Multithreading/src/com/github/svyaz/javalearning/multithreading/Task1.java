package com.github.svyaz.javalearning.multithreading;

public class Task1 implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ignore) {
        }
    }
}
