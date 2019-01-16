package com.github.svyaz.javalearning.shapes;

public class Square implements Shape {
    private static final String EXCEPTION_MESSAGE = "'side' must be greater than 0.";
    private double side;

    public Square(double side) throws IllegalArgumentException {
        if (side <= 0){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) throws IllegalArgumentException {
        if (side <= 0){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }
}