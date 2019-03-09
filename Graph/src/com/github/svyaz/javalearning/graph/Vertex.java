package com.github.svyaz.javalearning.graph;

import java.util.Objects;

class Vertex<T> {
    private T data;

    Vertex(T data) {
        this.data = data;
    }

    T getData() {
        return data;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Vertex<?> vertex = (Vertex<?>) object;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}
