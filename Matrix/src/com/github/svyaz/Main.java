package com.github.svyaz;

import com.github.svyaz.javalearning.matrix.Matrix;
import com.github.svyaz.javalearning.vector.Vector;

public class Main {
    public static void main(String[] args) {
        /*Vector v1 = new Vector(new double[]{1, 2});
        Vector v2 = new Vector(new double[]{3, 4, 5, 6});
        Vector v3 = new Vector(new double[]{7});

        Matrix matrix = new Matrix(new Vector[]{v1, v2, v3});
        System.out.println(matrix.toString());*/

        /*double[] d1 = {1, 2};
        double[] d2 = {3, 4};
        double[] d3 = {5, 6};*/

        double[][] matrix3x3 = {
                {3.0, 5.0, 2.0},
                {8.0, 4.0, 3.0},
                {3.0, 7.0, 2.0},
        };

        //Matrix matrix = new Matrix(new double[][]{d1, d2});
        Matrix matrix = new Matrix(matrix3x3);
        System.out.println(matrix.toString());
        //System.out.println(matrix.hashCode());
        //System.out.println(matrix.getRow(2).toString());
        //matrix.setRow(2, new Vector(new double[]{30, 40, 50}));
        //System.out.println(matrix.getRow(2).toString());
        //System.out.println(matrix.toString());
        //System.out.println(matrix.getColumn(0).toString());
        //matrix.setColumn(2, new Vector(new double[]{30, 40, 50}));
        //matrix.transpose();
        //matrix.multiplication(2);
        //System.out.println(matrix.toString());
        System.out.println(matrix.getDeterminant());


    }
}
