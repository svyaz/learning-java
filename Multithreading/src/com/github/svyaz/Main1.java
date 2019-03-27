package com.github.svyaz;

import com.github.svyaz.javalearning.multithreading.Task1;

public class Main1 {
    public static void main(String[] args) {
        // Task 1
        Thread newThread = new Thread(new Task1());
        newThread.start();
        System.out.println("Main thread ends.");
    }
}
