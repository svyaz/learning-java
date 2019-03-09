package com.github.svyaz.javalearning.graph;

public class Graph<T> {
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
            throw new IndexOutOfBoundsException();
        }
        return (T) vertices[index];
    }

}
