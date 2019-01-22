package com.github.svyaz;

import com.github.svyaz.javalearning.shapes.*;

import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Define shapes
        Circle circle1 = new Circle(2.5);
        Circle circle2 = new Circle(3.16);
        Rectangle rectangle1 = new Rectangle(1.3, 3.85);
        Rectangle rectangle2 = new Rectangle(3.1, 4.0);
        Square square1 = new Square(2.57);
        Square square2 = new Square(2.92);
        Triangle triangle1 = new Triangle(0, 0, 0, 3, 4, 0);
        Triangle triangle2 = new Triangle(2, 1, 4, 5, -1, 2);

        // Array of shapes
        Shape[] shapes = {circle1, circle2, rectangle1, rectangle2, square1, square2, triangle1, triangle2};

        // Sort by area,
        Shape maxAreaShape = getShapeWithMaxArea(shapes);
        System.out.println("--- Sorted by area ---");
        for (Shape shape : shapes) {
            System.out.printf(Locale.ROOT, "%.2f", shape.getArea());
            System.out.println();
        }
        System.out.println("Shape with max area: " + maxAreaShape.toString());
        System.out.println();

        // Sort by perimeter
        sortShapesByPerimeter(shapes);
        System.out.println("--- Sorted by perimeter ---");
        for (Shape shape : shapes) {
            System.out.printf(Locale.ROOT, "%.2f", shape.getPerimeter());
            System.out.println();
        }
        System.out.println("Shape with 2-nd perimeter: " + shapes[shapes.length - 2].toString());

        // HashCodes and equals, identical objects
        rectangle1 = new Rectangle(2, 3);
        rectangle2 = new Rectangle(2, 3);
        System.out.println("rectangle1.hashCode(): " + rectangle1.hashCode());
        System.out.println("rectangle2.hashCode(): " + rectangle2.hashCode());
        System.out.println("rectangle1.equals(rectangle1): " + rectangle1.equals(rectangle1));
        System.out.println("rectangle1.equals(rectangle2): " + rectangle1.equals(rectangle2));
        System.out.println("rectangle2.equals(rectangle1): " + rectangle2.equals(rectangle1));
        System.out.println("rectangle1.equals(null): " + rectangle1.equals(null));
        System.out.println();

        // HashCodes and equals, not identical objects
        circle1 = new Circle(23.1);
        circle2 = new Circle(23.2);
        System.out.println("circle1.hashCode(): " + circle1.hashCode());
        System.out.println("circle2.hashCode(): " + circle2.hashCode());
        System.out.println("circle1.equals(circle1): " + circle1.equals(circle1));
        System.out.println("circle1.equals(circle2): " + circle1.equals(circle2));
        System.out.println("circle2.equals(circle1): " + circle2.equals(circle1));
        System.out.println("circle1.equals(null): " + circle1.equals(null));
    }

    private static void sortShapesByArea(Shape[] shapes) {
        ShapeAreaComparator shapeAreaComparator = new ShapeAreaComparator();
        Arrays.sort(shapes, shapeAreaComparator);
    }

    private static void sortShapesByPerimeter(Shape[] shapes) {
        ShapePerimeterComparator shapePerimeterComparator = new ShapePerimeterComparator();
        Arrays.sort(shapes, shapePerimeterComparator);
    }

    private static Shape getShapeWithMaxArea(Shape[] shapes) {
        sortShapesByArea(shapes);
        return shapes[shapes.length - 1];
    }
}
