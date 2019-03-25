package com.github.svyaz;

import com.github.svyaz.javalearning.serialization.Matrix;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, -9},
        };
        Matrix matrix = new Matrix(data);

        System.out.println("Original matrix:");
        System.out.println(matrix);
        System.out.println();

        /*try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Serialization/fullMatrix.txt"))) {
            out.writeObject(matrix);
        } catch (IOException exception) {
            System.out.println("Exception happened:");
            exception.printStackTrace();
        }*/

        // Write half-matrix
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Serialization/halfMatrix.txt"))) {
            out.writeObject(matrix);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // Read half-matrix
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Serialization/halfMatrix.txt"))) {
            Matrix restoredMatrix = (Matrix) in.readObject();
            System.out.println("Restored matrix:");
            System.out.println(restoredMatrix);
            System.out.println();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
