package com.github.svyaz;

import com.github.svyaz.javalearning.serialization.Matrix;

public class Main {
    public static void main(String[] args) {

        int[][] data = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9},
        };
        Matrix matrix = new Matrix(data);

        System.out.println(matrix);

    }
}
