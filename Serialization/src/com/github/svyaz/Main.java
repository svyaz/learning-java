package com.github.svyaz;

import com.github.svyaz.javalearning.serialization.Matrix;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Serialization/matrixFull.txt"))) {
            out.writeObject(matrix);
        } catch (IOException exception) {
            System.out.println("Exception happened:");
            exception.printStackTrace();
        }
    }
}
