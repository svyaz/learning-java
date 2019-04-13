package com.github.svyaz;

import com.github.svyaz.javalearning.producerconsumer.ProducerConsumerManager;

public class Main {
    public static void main(String[] args) {
        ProducerConsumerManager manager = new ProducerConsumerManager();
        manager.start();
    }
}
