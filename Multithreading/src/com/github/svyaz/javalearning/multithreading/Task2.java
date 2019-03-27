package com.github.svyaz.javalearning.multithreading;

import java.util.List;

public class Task2 implements Runnable {
    List<Integer> list;
    int limit;

    public Task2(List<Integer> list, int limit) {
        this.list = list;
        this.limit = limit;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= limit; i++) {
                list.add(list.size(), i);
                Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
