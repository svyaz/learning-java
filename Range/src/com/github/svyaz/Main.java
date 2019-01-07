package com.github.svyaz;

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

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
