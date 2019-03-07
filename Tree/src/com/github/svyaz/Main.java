package com.github.svyaz;

import com.github.svyaz.javalearning.tree.Tree;

public class Main {
    public static void main(String[] args) {
        // Create intTree of integers.
        Tree<Integer> intTree = new Tree<>();
        intTree.add(10);
        intTree.add(9);
        intTree.add(20);
        intTree.add(22);
        intTree.add(18);
        intTree.add(19);
        intTree.add(21);

        // Print intTree
        System.out.println(intTree);

        // Perform an action by width
        intTree.forEachByWidth(x -> System.out.println((double) x / 2.0));
        System.out.println();

        // Create stringTree of strings.
        Tree<String> stringTree = new Tree<>();
        stringTree.add("One");
        stringTree.add("Two");
        stringTree.add("Three");
        stringTree.add("Four");
        stringTree.add("Five");
        stringTree.add("Six");
        stringTree.add("Seven");
        stringTree.add("Eight");
        stringTree.add("Nine");
        stringTree.add("Ten");

        // Print stringTree
        System.out.println(stringTree);

        // Perform an action by depth. Recursive
        stringTree.forEachByDepthRecursive(s -> System.out.println(s.toUpperCase()));
        System.out.println();

    }
}
