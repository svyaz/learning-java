package com.github.svyaz;

import com.github.svyaz.javalearning.graph.Graph;
import com.github.svyaz.javalearning.graph.Vertex;

//@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {

        // Graph ...
        Vertex<String>[] cities = (Vertex<String>[]) new Vertex[12];
        cities[0] = new Vertex<>("Moscow");
        cities[1] = new Vertex<>("London");
        cities[2] = new Vertex<>("Tokyo");
        cities[3] = new Vertex<>("Berlin");
        cities[4] = new Vertex<>("Sao Paolo");
        cities[5] = new Vertex<>("New York");
        cities[6] = new Vertex<>("Sidney");
        cities[7] = new Vertex<>("Singapore");
        cities[8] = new Vertex<>("Paris");
        cities[9] = new Vertex<>("Baku");
        cities[10] = new Vertex<>("Beijing");
        cities[11] = new Vertex<>("Rome");

        int[][] adjMatrix = new int[cities.length][cities.length];
        adjMatrix[0] = new int[]{0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        adjMatrix[1] = new int[]{1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0};
        adjMatrix[2] = new int[]{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0};
        adjMatrix[3] = new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0};
        adjMatrix[4] = new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        adjMatrix[5] = new int[]{1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        adjMatrix[6] = new int[]{1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        adjMatrix[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1};
        adjMatrix[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1};
        adjMatrix[9] = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1};
        adjMatrix[10] = new int[]{0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        adjMatrix[11] = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0};

        Graph<String> cityGraph = new Graph<>(cities, adjMatrix);
    }
}
