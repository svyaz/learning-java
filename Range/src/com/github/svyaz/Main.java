package com.github.svyaz;

import com.github.svyaz.javalearning.range.Range;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            Range range = new Range(3.4, 24.1904);
            System.out.println("My range: " + range.toString());
            System.out.println("Length: " + range.getLength());
            System.out.println();

            System.out.println("Set new 'from'");
            range.setFrom(5.0);
            System.out.println("Now my range: " + range.toString());
            System.out.println("Length: " + range.getLength());
            System.out.println();

            double p1 = 16.568;
            double p2 = 24.19041;
            System.out.println("Point p1(" + p1 + ") is inside my range: " + range.isInside(p1));
            System.out.println("Point p2(" + p2 + ") is inside my range: " + range.isInside(p2));
            System.out.println();

            // Crossing, Union, Subtraction
            Range r1 = new Range(2, 5);
            Range r2 = new Range(4, 7);
            Range r3 = new Range(8, 10);
            System.out.println("r1: " + r1.toString());
            System.out.println("r2: " + r2.toString());
            System.out.println("r3: " + r3.toString());
            System.out.println("Crossing r1 and r2: " + r1.getCrossing(r2).toString());
            System.out.println("Union of r2 and r3: " + Arrays.toString(r2.getUnion(r3)));
            System.out.println("Subtraction r1 and r2: " + Arrays.toString(r1.getSubtraction(r2)));
            System.out.println("Subtraction r1 and r3: " + Arrays.toString(r1.getSubtraction(r3)));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
