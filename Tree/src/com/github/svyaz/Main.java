package com.github.svyaz;

import com.github.svyaz.javalearning.tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(10);

        tree.add(8);
        tree.add(18);
        tree.add(6);
        tree.add(3);
        tree.add(5);
        tree.add(12);

        System.out.println(tree.search(31));

    }
}
