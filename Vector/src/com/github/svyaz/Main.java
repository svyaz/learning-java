package com.github.svyaz;

import com.github.svyaz.javalearning.vector.Vector;

public class Main {
    public static void main(String[] args) {

        Vector v1 = new Vector(new double[]{1, 2, 3});
        Vector v2 = new Vector(new double[]{1, 2, 3});
        v1.add(v2);

        System.out.println(v1.toString());


    }
}
