package com.github.svyaz.javalearning.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class Graph<T> {
    private final static String EXC_MSG_INDEX_OUT_OF_BOUNDS = "Specified index is out of bounds of vertices.";
    /**
     * Graph structure is a 2-dimensions array
     */
    private int[][] adjMatrix;

    /**
     * Graph members
     */
    private Vertex<T>[] vertices;

    /**
     * Creates a graph with specified vertices and adjacency matrix.
     */
    public Graph(Vertex<T>[] vertices, int[][] adjMatrix) {
        this.vertices = vertices;
        this.adjMatrix = adjMatrix;
    }

    /**
     * Number of vertices that are included in the graph.
     *
     * @return number of vertices.
     */
    public int size() {
        return vertices.length;
    }

    /**
     * Returns vertex by the specified index.
     *
     * @param index of the vertex.
     * @return vertex by the specified index.
     * @throws IndexOutOfBoundsException if the specified index is out of bounds of vertices array.
     */
    public Vertex<T> get(int index) {
        if (index < 0 || index >= vertices.length) {
            throw new IndexOutOfBoundsException(EXC_MSG_INDEX_OUT_OF_BOUNDS);
        }
        return vertices[index];
    }

    /**
     * Performs specified action for each element in the graph.
     * Traversing by width.
     *
     * @param action to perform.
     */
    public void forEachByWidth(Consumer<T> action) {
        int dim = vertices.length;
        boolean[] visited = new boolean[dim];

        for (int i = 0; i < dim; i++) {     // проход по несвязанным частям графа
            if (visited[i]) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {  // проход по очереди
                int index = queue.remove();
                action.accept(vertices[index].getData());   // действие с элементом
                for (int j = 0; j < dim; j++) { // проход по непосещенным элементам
                    if (!visited[j] && adjMatrix[index][j] == 1 && index != j) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
    }

    /**
     * Performs specified action for each element in the graph.
     * Traversing by depth without recursion.
     *
     * @param action to perform.
     */
    public void forEachByDepthNonRecursive(Consumer<T> action) {
        int dim = vertices.length;
        boolean[] visited = new boolean[dim];

        for (int i = 0; i < dim; i++) {     // проход по несвязанным частям графа
            if (visited[i]) {
                continue;
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            visited[i] = true;

            while (!stack.isEmpty()) {  // проход по очереди
                int index = stack.pop();
                action.accept(vertices[index].getData());   // действие с элементом
                for (int j = dim - 1; j >= 0; j--) { // проход по непосещенным элементам
                    if (!visited[j] && adjMatrix[index][j] == 1 && index != j) {
                        stack.push(j);
                        visited[j] = true;
                    }
                }
            }
        }
    }

    /**
     * Performs specified action for each element in the graph.
     * Traversing by depth with recursion.
     *
     * @param action to perform.
     */
    public void forEachByDepthRecursive(Consumer<T> action) {
        int dim = vertices.length;
        boolean[] visited = new boolean[dim];

        for (int i = 0; i < dim; i++) {     // проход по несвязанным частям графа
            if (visited[i]) {
                continue;
            }
            performRecursive(i, visited, action);
        }
    }

    /**
     * Internal supporting recursive method for going by depth.
     *
     * @param index   start index the graph part.
     * @param visited array of visited vertices.
     * @param action  to perform.
     */
    private void performRecursive(int index, boolean[] visited, Consumer<T> action) {
        action.accept(vertices[index].getData());
        visited[index] = true;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && adjMatrix[index][i] == 1 && index != i) {
                performRecursive(i, visited, action);
            }
        }
    }

    /**
     * Returns true if the specified object is equal to the graph.
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

        Graph<?> graph = (Graph<?>) object;
        if (!Arrays.equals(vertices, graph.vertices)) {
            return false;
        }
        for (int i = 0; i < vertices.length; i++) {
            if (!Arrays.equals(adjMatrix[i], graph.adjMatrix[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates hash code of the graph.
     *
     * @return hashCode integer value.
     */
    @Override
    public int hashCode() {
        int result = 1;
        for (int[] matrixRow : adjMatrix) {
            result = 37 * result + Arrays.hashCode(matrixRow);
        }
        result = 37 * result + Arrays.hashCode(vertices);
        return result;
    }
}
