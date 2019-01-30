package com.github.svyaz;

import com.github.svyaz.javalearning.matrix.Matrix;
import com.github.svyaz.javalearning.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 1}, {0, 1, 2}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 0}, {0, 1}, {1, 1}});

        System.out.println("--- Matrices ---");
        System.out.println("matrix1: " + matrix1.toString());
        System.out.println("matrix2: " + matrix2.toString());
        System.out.println();
        System.out.println("matrix1 * matrix2: " + Matrix.multiply(matrix1, matrix2).toString());
        System.out.println("matrix2 * matrix1: " + Matrix.multiply(matrix2, matrix1).toString());
        System.out.println();
        matrix1.setRow(0, new Vector(3));
        System.out.println("After matrix1.setRow():      " + matrix1.toString());
        matrix2.transpose();
        System.out.println("After matrix2.transpose():   " + matrix2.toString());
        System.out.println();
        Matrix matrix3 = Matrix.add(matrix1, matrix2);
        System.out.println("matrix3 = matrix1 + matrix2: " + matrix3.toString());
    }
}
