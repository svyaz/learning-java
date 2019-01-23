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

    public void add(Vector anotherVector) {
        changeVector(anotherVector, 1);
    }

    public void subtract(Vector anotherVector) {
        changeVector(anotherVector, -1);
    }

    private void changeVector(Vector anotherVector, int factor) {
        if (components.length != anotherVector.components.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < components.length; i++) {
            components[i] += factor * anotherVector.components[i];
        }
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
        final int prime = 37;
        int hash = 1;
        for (double component : components) {
            hash = prime * hash + Double.hashCode(component);
        }
        return hash;
    }
}
