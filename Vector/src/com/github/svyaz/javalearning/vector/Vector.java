package com.github.svyaz.javalearning.vector;


public class Vector {
    private double[] components;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException();
        }
        components = new double[dimension];
    }

    public Vector(int dimension, double[] components) {
        this(dimension);
        System.arraycopy(components, 0, this.components, 0,
                Math.min(dimension, components.length));
    }

    public Vector(double[] components) {
        this(components.length, components);
    }

    public Vector(Vector vector) {
        components = new double[vector.components.length];
        System.arraycopy(vector.components, 0, components, 0,
                vector.components.length);
    }

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        if (components.length != this.components.length) {
            throw new IllegalArgumentException();
        }
        System.arraycopy(components, 0, this.components, 0,
                this.components.length);
    }

    public int getSize() {
        return components.length;
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
}
