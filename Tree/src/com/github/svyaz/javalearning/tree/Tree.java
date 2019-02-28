package com.github.svyaz.javalearning.tree;

public class Tree<T extends Comparable> {
    /**
     * Root node
     */
    private TreeNode<T> root;

    /**
     * Counter for tree size.
     */
    private int count;

    /**
     * Creates Tree with 1 item specified as root data.
     */
    public Tree(T data) {
        root = new TreeNode<T>(data);
        count = 1;
    }

    /**
     * Returns size of the tree.
     */
    public int size() {
        return count;
    }
}
