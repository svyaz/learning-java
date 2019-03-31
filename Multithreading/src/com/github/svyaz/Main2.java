package com.github.svyaz;

import com.github.svyaz.javalearning.multithreading.Task2;
import com.github.svyaz.javalearning.multithreading.SyncTask2;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        // Task 2
        // Without synchronization
        List<Integer> integerList1 = new ArrayList<>(200);
        Thread thread1 = new Thread(new Task2(integerList1, 100));
        Thread thread2 = new Thread(new Task2(integerList1, 100));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Without synchronization:");
        System.out.println("List size: " + integerList1.size());
        System.out.println(integerList1.toString());
        System.out.println();

        // With synchronization
        List<Integer> integerList2 = new ArrayList<>(200);
        Thread syncTread1 = new Thread(new SyncTask2(integerList2, 100));
        Thread syncTread2 = new Thread(new SyncTask2(integerList2, 100));
        syncTread1.start();
        syncTread2.start();
        syncTread1.join();
        syncTread2.join();
        System.out.println("With synchronization:");
        System.out.println("List size: " + integerList2.size());
        System.out.println(integerList2.toString());
    }
}
