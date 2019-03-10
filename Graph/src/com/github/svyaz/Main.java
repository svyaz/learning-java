package com.github.svyaz;

import com.github.svyaz.javalearning.graph.Graph;
import com.github.svyaz.javalearning.graph.Vertex;

@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        // Graph ...
        Vertex<String>[] cities = (Vertex<String>[]) new Vertex[12];
        cities[0] = new Vertex<>("0 - Moscow");
        cities[1] = new Vertex<>("1 - London");
        cities[2] = new Vertex<>("2 - Tokyo");
        cities[3] = new Vertex<>("3 - Berlin");
        cities[4] = new Vertex<>("4 - Sao Paolo");
        cities[5] = new Vertex<>("5 - New York");
        cities[6] = new Vertex<>("6 - Sidney");
        cities[7] = new Vertex<>("7 - Singapore");
        cities[8] = new Vertex<>("8 - Paris");
        cities[9] = new Vertex<>("9 - Baku");
        cities[10] = new Vertex<>("10 - Beijing");
        cities[11] = new Vertex<>("11 - Rome");

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

        System.out.println("Traversing by width:");
        cityGraph.forEachByWidth(s -> System.out.println(s.toUpperCase()));
        System.out.println();

        System.out.println("Traversing by depth:");
        cityGraph.forEachByDepth(s -> System.out.println(s.toUpperCase()));
        System.out.println();
    }
}
