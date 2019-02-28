package com.github.svyaz.javalearning.tree;

import java.util.Objects;

class TreeNode<T extends Comparable> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    TreeNode(T data) {
        this.data = data;
    }

    TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    TreeNode<T> getLeft() {
        return left;
    }

    void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    TreeNode<T> getRight() {
        return right;
    }

    void setRight(TreeNode<T> right) {
        this.right = right;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        TreeNode<?> treeNode = (TreeNode<?>) object;

        return data != null ? data.equals(treeNode.data) : treeNode.data == null;
    }
}
