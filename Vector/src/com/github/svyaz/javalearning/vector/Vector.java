package com.github.svyaz.javalearning.vector;

import java.util.Arrays;

public class Vector {
    private static final String EXCEPTION_CONSTRUCTOR_MESSAGE = "Dimension of Vector must be greater than 0.";
    private static final String EXCEPTION_INDEX_OUT_OF_BOUNDS_MESSAGE = "Index out of bounds of Vector dimension.";
    private double[] components;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException(EXCEPTION_CONSTRUCTOR_MESSAGE);
        }
        components = new double[dimension];
    }

    public Vector(int dimension, double[] components) {
        this(dimension);
        this.components = Arrays.copyOf(components, dimension);
    }

    public Vector(double[] components) {
        this(components.length, components);
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.getSize());
    }

    public static Vector add(Vector vector1, Vector vector2) {
        return createVectorFromTwo(vector1, vector2, 1);
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        return createVectorFromTwo(vector1, vector2, -1);
    }

    private static Vector createVectorFromTwo(Vector vector1, Vector vector2, int factor) {
        final int dimension = Math.max(vector1.components.length, vector2.components.length);
        Vector result = new Vector(dimension);
        for (int i = 0; i < dimension; i++) {
            result.components[i] = (i < vector1.components.length ? vector1.components[i] : 0.0) +
                    factor * (i < vector2.components.length ? vector2.components[i] : 0.0);
        }
        return result;
    }

    public static double scalarMultiplication(Vector vector1, Vector vector2) {
        final int minDimension = Math.min(vector1.getSize(), vector2.getSize());
        double result = 0.0;
        for (int i = 0; i < minDimension; i++) {
            result += vector1.getComponent(i) * vector2.getComponent(i);
        }
        return result;
    }

    public double getComponent(int index) {
        if (index < 0 || index > components.length - 1) {
            throw new IndexOutOfBoundsException(EXCEPTION_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index > components.length - 1) {
            throw new IndexOutOfBoundsException(EXCEPTION_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        components[index] = value;
    }

    public int getSize() {
        return components.length;
    }

    public double getLength() {
        double tmp = 0;
        for (double component : components) {
            tmp += Math.pow(component, 2);
        }
        return Math.sqrt(tmp);
    }

    public void add(Vector anotherVector) {
        final int tmpDimension = Math.max(getSize(), anotherVector.getSize());
        double[] tmpComponents = Arrays.copyOf(components, tmpDimension);
        for (int i = 0; i < anotherVector.getSize(); i++) {
            tmpComponents[i] += anotherVector.components[i];
        }
        components = tmpComponents;
    }

    public void subtract(Vector anotherVector) {
        final int tmpDimension = Math.max(getSize(), anotherVector.getSize());
        double[] tmpComponents = Arrays.copyOf(components, tmpDimension);
        for (int i = 0; i < anotherVector.getSize(); i++) {
            tmpComponents[i] -= anotherVector.components[i];
        }
        components = tmpComponents;
    }

    public void multiplication(double number) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= number;
        }
    }

    public void reverse() {
        multiplication(-1);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Vector {");
        for (int i = 0; i < components.length; i++) {
            str.append(components[i]);
            str.append(i == components.length - 1 ? "}" : ", ");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Vector vector = (Vector) object;
        if (vector.components.length != components.length) {
            return false;
        }
        for (int i = 0; i < components.length; i++) {
            if (Double.compare(vector.components[i], components[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }
}
