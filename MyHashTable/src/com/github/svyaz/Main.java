package com.github.svyaz;

import com.github.svyaz.javalearning.myhashtable.MyHashTable;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Create myHashTable
        MyHashTable<Integer> myHashTable = new MyHashTable<>(1000);
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            myHashTable.add(Math.abs(random.nextInt() % 100));
        }

        // Use iterator (1 variant with cycles)
        Date start1 = new Date();
        Iterator iterator1 = myHashTable.iterator();
        int sum = 0;
        while (iterator1.hasNext()) {
            sum += (int) iterator1.next();
        }
        Date end1 = new Date();
        System.out.println("Iterator 1:");
        System.out.println("  Sum:  " + sum);
        System.out.println("  Time: " + (end1.getTime() - start1.getTime()) + " ms");
        System.out.println();

        // Use iterator (2 variant)
        Date start2 = new Date();
        Iterator iterator2 = myHashTable.iterator2();
        sum = 0;
        while (iterator2.hasNext()) {
            sum += (int) iterator2.next();
        }
        Date end2 = new Date();
        System.out.println("Iterator 2:");
        System.out.println("  Sum:  " + sum);
        System.out.println("  Time: " + (end2.getTime() - start2.getTime()) + " ms");
        System.out.println();
    }
}
