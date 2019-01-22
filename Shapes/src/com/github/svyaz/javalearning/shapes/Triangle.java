package com.github.svyaz.javalearning.shapes;

import java.util.Locale;
import java.util.Objects;

public class Triangle implements Shape {
    private static final double EPSILON = 1e-10;
    private static final String EXCEPTION_MESSAGE = "Points cannot lay on one line.";
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double[] tmpSides = calculateSides(x1, y1, x2, y2, x3, y3);
        if (!isSidesCorrect(tmpSides)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    // Getters & setters
    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        double[] tmpSides = calculateSides(x1, this.y1, this.x2, this.y2, this.x3, this.y3);
        if (isSidesCorrect(tmpSides)) {
            this.x1 = x1;
            return;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        double[] tmpSides = calculateSides(this.x1, y1, this.x2, this.y2, this.x3, this.y3);
        if (isSidesCorrect(tmpSides)) {
            this.y1 = y1;
            return;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        double[] tmpSides = calculateSides(this.x1, this.y1, x2, this.y2, this.x3, this.y3);
        if (isSidesCorrect(tmpSides)) {
            this.x2 = x2;
            return;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        double[] tmpSides = calculateSides(this.x1, this.y1, this.x2, y2, this.x3, this.y3);
        if (isSidesCorrect(tmpSides)) {
            this.y2 = y2;
            return;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        double[] tmpSides = calculateSides(this.x1, this.y1, this.x2, this.y2, x3, this.y3);
        if (isSidesCorrect(tmpSides)) {
            this.x3 = x3;
            return;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        double[] tmpSides = calculateSides(this.x1, this.y1, this.x2, this.y2, this.x3, y3);
        if (isSidesCorrect(tmpSides)) {
            this.y3 = y3;
            return;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    // Calculate sides
    private static double[] calculateSides(double x1, double y1, double x2, double y2, double x3, double y3) {
        return new double[]{
                getSide(x1, y1, x2, y2),
                getSide(x2, y2, x3, y3),
                getSide(x1, y1, x3, y3)
        };
    }

    private static double getSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Check sides correctness
    private static boolean isSidesCorrect(double[] sides) {
        // проверка что точки не лежат на одной прямой
        return (Math.abs(sides[0] + sides[1] - sides[2]) > EPSILON &&
                Math.abs(sides[0] + sides[2] - sides[1]) > EPSILON &&
                Math.abs(sides[1] + sides[2] - sides[0]) > EPSILON
        );
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        return Math.abs(((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) * 0.5);
    }

    @Override
    public double getPerimeter() {
        double[] sides = calculateSides(x1, y1, x2, y2, x3, y3);
        return sides[0] + sides[1] + sides[2];
    }

    @Override
    public String toString() {
        double[] sides = calculateSides(x1, y1, x2, y2, x3, y3);
        return String.format(Locale.ROOT,
                "Triangle, sides: [%.2f, %.2f, %.2f], area: %.2f, perimeter: %.2f",
                sides[0], sides[1], sides[2], getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) object;
        return Double.compare(triangle.x1, x1) == 0 &&
                Double.compare(triangle.y1, y1) == 0 &&
                Double.compare(triangle.x2, x2) == 0 &&
                Double.compare(triangle.y2, y2) == 0 &&
                Double.compare(triangle.x3, x3) == 0 &&
                Double.compare(triangle.y3, y3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, x3, y3);
    }
}
