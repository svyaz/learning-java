package com.github.svyaz.javalearning.multithreading;

import java.util.List;

public class SyncTask2 extends Task2 {
    private static final Object lock = new Object();

    public SyncTask2(List<Integer> list, int limit) {
        super(list, limit);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= limit; i++) {
                synchronized (lock) {
                    list.add(list.size(), i);
                }
                Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
