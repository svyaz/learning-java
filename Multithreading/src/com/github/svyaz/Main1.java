package com.github.svyaz;

import com.github.svyaz.javalearning.multithreading.Task1;

public class Main1 {
    public static void main(String[] args) {
        // Task 1
        try {
            Thread newThread = new Thread(new Task1());
            newThread.start();
            newThread.join();
        } catch (InterruptedException ignore) {
        }
        System.out.println("Main thread continues.");
    }
}
