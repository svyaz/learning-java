package com.github.svyaz;

import com.github.svyaz.javalearning.multithreading.Task1;

public class Main1 {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1:");
        Thread task1Thread = new Thread(new Task1());
        task1Thread.start();
        System.out.println("Main thread ends.");
        System.out.println();
    }
}
