package com.github.svyaz.javalearning.shapes;

import java.util.Locale;
import java.util.Objects;

public class Square implements Shape {
    private static final String EXCEPTION_MESSAGE = "'side' must be greater than 0.";
    private double side;

    public Square(double side) throws IllegalArgumentException {
        if (side <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) throws IllegalArgumentException {
        if (side <= 0) {
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

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "Square, side: %.2f, area: %.2f, perimeter: %.2f",
                side, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Square square = (Square) object;
        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }
}
