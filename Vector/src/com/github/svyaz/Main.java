package com.github.svyaz;

import com.github.svyaz.javalearning.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1, 2});
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4});

        System.out.println("--- Vectors ---");
        System.out.println("vector1: " + vector1 + ", hashCode: " + vector1.hashCode());
        System.out.println("vector2: " + vector2 + ", hashCode: " + vector2.hashCode());
        System.out.println("Is vector1 equals vector2: " + vector1.equals(vector2));
        System.out.println();

        System.out.println("--- Static methods ---");
        System.out.println("vector1 + vector2: " + Vector.add(vector1, vector2));
        System.out.println("vector1 - vector2: " + Vector.subtract(vector1, vector2));
        System.out.println("Scalar multiplication: " + Vector.scalarMultiplication(vector1, vector2));
        System.out.println();

        System.out.println("--- Getters and setters ---");
        System.out.println("Get all components: " + Arrays.toString(vector1.getComponents()));
        vector1.setComponents(new double[]{-2.0, -3.0});
        System.out.println("After set all components: " + Arrays.toString(vector1.getComponents()));
        System.out.println("Get separate components: " + vector1.getComponent(0) + ", " + vector1.getComponent(1));
        vector1.setComponent(0, 1.0);
        vector1.setComponent(1, 2.0);
        System.out.println("After set separate components: " + vector1.getComponent(0) + ", " + vector1.getComponent(1));
        System.out.println("vector1 dimension: " + vector1.getSize());
        System.out.println("vector2 dimension: " + vector2.getSize());
        System.out.println("vector1 length: " + String.format("%.2f", vector1.getLength()));
        System.out.println("vector2 length: " + String.format("%.2f", vector2.getLength()));
        System.out.println();

        System.out.println("--- Methods of Vector object ---");
        Vector vector3 = new Vector(new double[]{3.0, 4.0});
        System.out.println("vector1: " + vector1);
        System.out.println("vector3: " + vector3);
        vector1.add(vector3);
        System.out.println("vector1 + vector3: " + vector1);
        vector3.subtract(vector1);
        System.out.println("vector3 - vector1: " + vector3);
        System.out.println("vector2: " + vector2);
        vector2.multiplication(2.0);
        System.out.println("vector2 multiplied by scalar 2.0: " + vector2);
        vector2.reverse();
        System.out.println("Reversed vector2: " + vector2);
        System.out.println();

        System.out.println("--- That's all. Thank you. ---");
    }
}
