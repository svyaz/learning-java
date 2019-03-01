package com.github.svyaz;

import com.github.svyaz.javalearning.tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(10);
        System.out.println(tree.size());

        tree.add(8);
        System.out.println(tree.size());

    }
}
