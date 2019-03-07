package com.github.svyaz;

import com.github.svyaz.javalearning.tree.Tree;

public class Main {
    public static void main(String[] args) {
        // Create tree
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(9);
        tree.add(20);
        tree.add(22);
        tree.add(18);
        tree.add(19);
        tree.add(21);

        // Print tree
        System.out.println(tree);

        // Perform an action by width
        tree.forEachByWidth(x -> System.out.println((double) x / 2.0));


    }
}
