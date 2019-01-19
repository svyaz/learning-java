package com.github.svyaz.javalearning.shapes;

import java.util.Locale;

public class Circle implements Shape {
    private static final String EXCEPTION_MESSAGE = "'radius' must be greater than 0.";
    private double radius;

    public Circle(double radius) throws IllegalArgumentException {
        if (radius <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "Circle, radius: %.2f, area: %.2f, perimeter: %.2f",
                radius, getArea(), getPerimeter());
    }
}
