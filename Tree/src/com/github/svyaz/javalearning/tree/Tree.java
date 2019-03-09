package com.github.svyaz.javalearning.tree;

import java.util.*;
import java.util.function.Consumer;

public class Tree<T> {
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
     * Creates empty Tree.
     */
    public Tree() {
    }

    /**
     * Creates empty Tree with specified comparator.
     */
    public Tree(Comparator<T> comparator) {
        this.comparator = comparator;
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
        if (data1 == null && data2 == null) {
            return 0;
        }
        if (data1 == null) {
            return -1;
        }
        if (data2 == null) {
            return 1;
        }

        if (comparator == null) {
            @SuppressWarnings("unchecked")
            Comparable<T> comp = (Comparable<T>) data1;
            return comp.compareTo(data2);
        }
        return comparator.compare(data1, data2);
    }

    /**
     * Returns true if the specified data is present in the tree.
     *
     * @return true if specified data is present, false otherwise.
     * @throws IllegalArgumentException if specified data is null.
     */
    public boolean contains(T data) {
        if (count == 0) {
            return false;
        }
        TreeNode<T> current = root;
        while (true) {
            int compareResult = compare(data, current.getData());
            if (compareResult == 0) {
                return true;
            } else if (compareResult < 0) {
                if (current.getLeft() == null) {
                    break;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    break;
                }
                current = current.getRight();
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
        if (root == null) {
            root = new TreeNode<>(data);
        } else {
            TreeNode<T> newNode = new TreeNode<>(data);
            TreeNode<T> current = root;
            while (true) {
                if (compare(data, current.getData()) < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft(newNode);
                        break;
                    }
                    current = current.getLeft();
                } else {
                    if (current.getRight() == null) {
                        current.setRight(newNode);
                        break;
                    }
                    current = current.getRight();
                }
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
        if (root == null) {
            return false;
        }

        TreeNode<T> current = root;
        TreeNode<T> parent = null;
        while (true) {
            int compareResult = compare(data, current.getData());

            if (compareResult == 0) {
                break;
            } else if (compareResult < 0) {
                if (current.getLeft() == null) {
                    return false;
                }
                parent = current;
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    return false;
                }
                parent = current;
                current = current.getRight();
            }
        }

        if (current.getLeft() == null && current.getRight() == null) {
            // нет потомков
            removeNode(current, parent, null);
        } else if (current.getLeft() != null && current.getRight() == null) {
            // есть только левая ветвь
            removeNode(current, parent, current.getLeft());
        } else if (current.getLeft() == null && current.getRight() != null) {
            // есть только правая ветвь
            removeNode(current, parent, current.getRight());
        } else {
            // если есть обе ветви
            for (TreeNode<T> minNode = current.getRight(), minParent = current;
                    ;
                 minParent = minNode, minNode = minNode.getLeft()) {
                if (minNode.getLeft() == null) {
                    if (minParent == current) {
                        minNode.setLeft(current.getLeft());
                        removeNode(current, parent, current.getRight());
                    } else {
                        minParent.setLeft(minNode.getRight()); // установка правого потомка
                        minNode.setLeft(current.getLeft());
                        minNode.setRight(current.getRight());
                        removeNode(minNode, parent, minNode);
                    }
                    break;
                }
            }
        }
        --count;
        return true;
    }

    /**
     * Internal supporting method for removing node.
     *
     * @param node   to remove.
     * @param parent node which left or right son is linked to next node.
     * @param next   node.
     */
    private void removeNode(TreeNode<T> node, TreeNode<T> parent, TreeNode<T> next) {
        if (parent == null) {
            root = next;
        } else {
            if (compare(node.getData(), parent.getData()) < 0) {
                parent.setLeft(next);
            } else {
                parent.setRight(next);
            }
        }
    }

    /**
     * Performs specified action for each element in the tree.
     * Goes by width.
     *
     * @param action to perform.
     */
    public void forEachByWidth(Consumer<T> action) {
        if (count == 0) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode<T> current = queue.remove();
            action.accept(current.getData());
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    /**
     * Performs specified action for each element in the tree.
     * Goes by depth.
     * Non recursive.
     *
     * @param action to perform.
     */
    public void forEachByDepthNonRecursive(Consumer<T> action) {
        if (count == 0) {
            return;
        }
        Deque<TreeNode<T>> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode<T> current = stack.pop();
            action.accept(current.getData());
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
    }

    /**
     * Performs specified action for each element in the tree.
     * Goes by depth.
     * Recursive.
     *
     * @param action to perform.
     */
    public void forEachByDepthRecursive(Consumer<T> action) {
        if (count == 0) {
            return;
        }
        performRecursive(root, action);
    }

    /**
     * Internal supporting recursive method for going by depth.
     *
     * @param node   for perform action to.
     * @param action action to perform.
     */
    private void performRecursive(TreeNode<T> node, Consumer<T> action) {
        action.accept(node.getData());

        TreeNode<T> left = node.getLeft();
        TreeNode<T> right = node.getRight();
        if (left == null && right == null) {
            return;
        }
        if (left != null) {
            performRecursive(left, action);
        }
        if (right != null) {
            performRecursive(right, action);
        }
    }

    /**
     * @return string representation of the tree.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tree (count = " + count + "):" + System.lineSeparator());
        if (count == 0) {
            return sb.append("empty").toString();
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode<T> current = queue.remove();
            sb.append(current.getData()).append(" (left: ");
            TreeNode<T> left = current.getLeft();
            TreeNode<T> right = current.getRight();
            if (left != null) {
                queue.add(left);
                sb.append(left.getData());
            } else {
                sb.append("--");
            }
            sb.append(", right: ");
            if (right != null) {
                queue.add(right);
                sb.append(right.getData());
            } else {
                sb.append("--");
            }
            sb.append(')').append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * Returns true if the specified object is equal to the tree.
     *
     * @param object compare with.
     * @return true for equal objects.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Tree<?> tree = (Tree<?>) object;
        if (count != tree.count) {
            return false;
        }
        if (comparator != null ? !comparator.equals(tree.comparator) : tree.comparator != null) {
            return false;
        }
        if (count == 0) {
            return true;
        }

        Deque<TreeNode<T>> thisStack = new LinkedList<>();
        Deque<TreeNode<?>> treeStack = new LinkedList<>();
        thisStack.push(this.root);
        treeStack.push(tree.root);
        while (thisStack.size() > 0) {
            TreeNode<T> thisCurrent = thisStack.pop();
            TreeNode<?> treeCurrent = treeStack.pop();
            if (!Objects.equals(thisCurrent.getData(), treeCurrent.getData()) ||
                    !Objects.equals(thisCurrent.getRight(), treeCurrent.getRight()) ||
                    !Objects.equals(thisCurrent.getLeft(), treeCurrent.getLeft())) {
                return false;
            }
            if (thisCurrent.getRight() != null) {
                thisStack.push(thisCurrent.getRight());
                treeStack.push(treeCurrent.getRight());
            }
            if (thisCurrent.getLeft() != null) {
                thisStack.push(thisCurrent.getLeft());
                treeStack.push(treeCurrent.getLeft());
            }
        }
        return true;
    }

    /**
     * Calculates hash code of the tree.
     *
     * @return hashCode integer value.
     */
    @Override
    public int hashCode() {
        int result = 37 + Objects.hashCode(comparator);
        if (count == 0) {
            return result;
        }
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode<T> current = queue.remove();
            result = 37 * result + current.hashCode();
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return result;
    }
}
