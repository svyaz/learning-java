package com.github.svyaz;

import com.github.svyaz.javalearning.matrix.Matrix;
import com.github.svyaz.javalearning.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(new double[]{1, 2});
        Vector v2 = new Vector(new double[]{3, 4, 5, 6});
        Vector v3 = new Vector(new double[]{7});

        Matrix matrix = new Matrix(new Vector[]{v1, v2, v3});
        System.out.println(matrix.toString());
    }
}
