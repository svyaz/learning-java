package com.github.svyaz.javalearning.tree;

import java.util.Comparator;
import java.util.LinkedList;

public class Tree<T> {
    private static final String MSG_EXCEPTION_NULL_NOT_ACCEPTABLE = "null is not acceptable as data.";
    /**
     * Root node
     */
    private TreeNode<T> root;

    /**
     * Internal comparator for ordering tree elements.
     */
    private Comparator<T> comparator;

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
        this(data, null);
    }

    /**
     * Creates Tree with 1 item specified as root data and
     * specified comparator.
     *
     * @throws IllegalArgumentException if specified data is null.
     */
    public Tree(T data, Comparator<T> comparator) {
        if (data == null) {
            throw new IllegalArgumentException(MSG_EXCEPTION_NULL_NOT_ACCEPTABLE);
        }
        this.comparator = comparator;
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
     * Tries to use comparator or casts specified data to Comparable<T>.
     * Internal method.
     *
     * @return a negative integer, zero, or a positive integer as data1 is less
     * than, equal to, or greater than data2.
     * @throws ClassCastException if data1 cannot be cast to Comparable<T>.
     */
    private int compare(T data1, T data2) {
        if (comparator == null) {
            @SuppressWarnings("unchecked")
            Comparable<T> comp = (Comparable<T>) data1;
            return comp.compareTo(data2);
        }
        return comparator.compare(data1, data2);
    }

    /**
     * Searches specified data in the tree.
     *
     * @return true if specified data is present, false otherwise.
     * @throws IllegalArgumentException if specified data is null.
     */
    public boolean search(T data) {
        if (data == null) {
            throw new IllegalArgumentException(MSG_EXCEPTION_NULL_NOT_ACCEPTABLE);
        }

        TreeNode<T> currentNode = root;
        while (true) {
            int compareResult = compare(data, currentNode.getData());
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
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException(MSG_EXCEPTION_NULL_NOT_ACCEPTABLE);
        }

        TreeNode<T> newNode = new TreeNode<>(data);
        TreeNode<T> currentNode = root;
        while (true) {
            if (compare(data, currentNode.getData()) < 0) {
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
     * Removes first occurrence of the specified data in the tree.
     *
     * @return true if the tree was changed as a result of the method call.
     * @throws IllegalArgumentException if specified data is null.
     */
    public boolean remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException(MSG_EXCEPTION_NULL_NOT_ACCEPTABLE);
        }

        TreeNode<T> currentNode = root;
        TreeNode<T> parent = null;
        while (true) {
            int compareResult = compare(data, currentNode.getData());

            if (compareResult == 0) {

                //1
                if (currentNode.getLeft() == null && currentNode.getRight() == null) {

                }

                //2

                //3


                return true;


            } else if (compareResult < 0) {
                if (currentNode.getLeft() == null) {
                    break;
                }
                parent = currentNode;
                currentNode = currentNode.getLeft();
            } else {
                if (currentNode.getRight() == null) {
                    break;
                }
                parent = currentNode;
                currentNode = currentNode.getRight();
            }
        }
        return false;
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

    //TODO Удаление первого вхождения узла по значению
    //TODO Обход в ширину
    //TODO Обход в глубину с рекурсией
    //TODO Обход в глубину без рекурсии
    //TODO hashCode()
    //TODO equals()
}
