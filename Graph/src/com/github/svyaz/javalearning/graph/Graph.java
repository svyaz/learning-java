package com.github.svyaz.javalearning.graph;

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
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= vertices.length) {
            throw new IndexOutOfBoundsException(EXC_MSG_INDEX_OUT_OF_BOUNDS);
        }
        return (T) vertices[index];
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
     * Traversing by depth.
     *
     * @param action to perform.
     */
    public void forEachByDepth(Consumer<T> action) {
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
                for (int j = 0; j < dim; j++) { // проход по непосещенным элементам
                    if (!visited[j] && adjMatrix[index][j] == 1 && index != j) {
                        stack.push(j);
                        visited[j] = true;
                    }
                }
            }
        }
    }
}
