package com.github.svyaz.javalearning.shapes;

import java.util.Locale;

public class Rectangle implements Shape {
    private static final String EXCEPTION_MESSAGE_BOTH = "'width' and 'height' must be greater than 0.";
    private static final String EXCEPTION_MESSAGE_WIDTH = "'width' must be greater than 0.";
    private static final String EXCEPTION_MESSAGE_HEIGHT = "'height' must be greater than 0.";
    private double width;
    private double height;

    public Rectangle(double width, double height) throws IllegalArgumentException {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_BOTH);
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) throws IllegalArgumentException {
        if (width <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_WIDTH);
        }
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws IllegalArgumentException {
        if (height <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_HEIGHT);
        }
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT,
                "Rectangle, width: %.2f, height: %.2f, area: %.2f, perimeter: %.2f",
                width, height, getArea(), getPerimeter());
    }
}
