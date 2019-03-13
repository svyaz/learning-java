package com.github.svyaz;

import com.github.svyaz.javalearning.graph.Graph;
import com.github.svyaz.javalearning.graph.Vertex;

@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        // Graph ...
        Vertex<String>[] cities = (Vertex<String>[]) new Vertex[]{
                new Vertex<>("0 - Moscow"),
                new Vertex<>("1 - London"),
                new Vertex<>("2 - Tokyo"),
                new Vertex<>("3 - Berlin"),
                new Vertex<>("4 - Sao Paolo"),
                new Vertex<>("5 - New York"),
                new Vertex<>("6 - Sidney"),
                new Vertex<>("7 - Singapore"),
                new Vertex<>("8 - Paris"),
                new Vertex<>("9 - Baku"),
                new Vertex<>("10 - Beijing"),
                new Vertex<>("11 - Rome"),
        };

        int[][] adjMatrix = new int[][]{
                {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
        };

        Graph<String> cityGraph = new Graph<>(cities, adjMatrix);

        System.out.println("Traversing by width:");
        cityGraph.forEachByWidth(s -> System.out.println(s.toUpperCase()));
        System.out.println();

        System.out.println("Traversing by depth without recursion:");
        cityGraph.forEachByDepthNonRecursive(s -> System.out.println(s.toUpperCase()));
        System.out.println();
    }
}
