package com.github.svyaz;

import com.github.svyaz.javalearning.vector.Vector;

public class Main {
    public static void main(String[] args) {

        Vector v1 = new Vector(new double[]{1, 2});
        Vector v2 = new Vector(new double[]{1, 2, 3, 4});

        System.out.println(Vector.add(v1, v2).toString());


    }
}
