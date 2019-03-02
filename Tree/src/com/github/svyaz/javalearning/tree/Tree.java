package com.github.svyaz.javalearning.tree;

import java.util.LinkedList;

public class Tree<T extends Comparable> {
    private static final String MSG_EXCEPTION_NULL_NOT_ACCEPTABLE = "null is not acceptable as data.";
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
     *
     * @throws IllegalArgumentException if specified data is null.
     */
    public Tree(T data) {
        if (data == null) {
            throw new IllegalArgumentException(MSG_EXCEPTION_NULL_NOT_ACCEPTABLE);
        }
        root = new TreeNode<>(data);
        count = 1;
    }

    /**
     * Returns size of the tree.
     *
     * @return number of elements (nodes) in the tree.
     */
    public int size() {
        return count;
    }

    /**
     * Search specified data in the tree.
     *
     * @return true if specified data is present, false otherwise.
     * @throws IllegalArgumentException if specified data is null.
     */
    @SuppressWarnings("unchecked")
    public boolean search(T data) {
        if (data == null) {
            throw new IllegalArgumentException(MSG_EXCEPTION_NULL_NOT_ACCEPTABLE);
        }

        TreeNode<T> currentNode = root;
        while (true) {
            int compareResult = data.compareTo(currentNode.getData());
            if (compareResult == 0) {
                return true;
            } else if (compareResult < 0) {
                if (currentNode.getLeft() == null) {
                    break;
                }
                currentNode = currentNode.getLeft();
            } else {
                if (currentNode.getRight() == null) {
                    break;
                }
                currentNode = currentNode.getRight();
            }
        }
        return false;
    }

    /**
     * Adds data as new node to the tree with specified data.
     *
     * @throws IllegalArgumentException if specified data is null.
     */
    @SuppressWarnings("unchecked")
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException(MSG_EXCEPTION_NULL_NOT_ACCEPTABLE);
        }

        TreeNode<T> newNode = new TreeNode<>(data);
        TreeNode<T> currentNode = root;
        while (true) {
            if (data.compareTo(currentNode.getData()) < 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    break;
                }
                currentNode = currentNode.getLeft();
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    break;
                }
                currentNode = currentNode.getRight();
            }
        }
        ++count;
    }

    /**
     * @return string representation of the tree.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tree:" + System.lineSeparator());
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        queue.addFirst(root);

        while (queue.size() > 0) {
            TreeNode<T> current = queue.getFirst();
            sb.append(current.getData()).append(" (left: ");
            TreeNode<T> left = current.getLeft();
            TreeNode<T> right = current.getRight();
            if (left != null) {
                queue.addLast(left);
                sb.append(left.getData());
            } else {
                sb.append("null");
            }
            sb.append(", right: ");
            if (right != null) {
                queue.addLast(right);
                sb.append(right.getData());
            } else {
                sb.append("null");
            }
            sb.append(')').append(System.lineSeparator());
            queue.removeFirst();
        }
        return sb.toString();
    }

    //TODO Поиск узла
    //TODO Удаление первого вхождения узла по значению
    //TODO Получение числа элементов ???
    //TODO Обход в ширину
    //TODO Обход в глубину с рекурсией
    //TODO Обход в глубину без рекурсии
    //TODO hashCode()
    //TODO equals()
}
