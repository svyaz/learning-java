package com.github.svyaz;

import com.github.svyaz.javalearning.tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(10);

        tree.add(9);
        tree.add(20);
        tree.add(22);
        tree.add(18);
        tree.add(21);
        tree.add(21);

        System.out.println(tree);
        tree.remove(20);
        System.out.println(tree);


    }
}
