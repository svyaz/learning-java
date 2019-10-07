package com.github.svyaz.javalearning.graph;

import com.github.svyaz.javalearning.graph.Vertex;
import org.junit.Assert;
import org.junit.Test;

public class VertexTest {
    @Test
    public void constructorTest() {
        Vertex<String> vertex = new Vertex<>("Hi there");
        Assert.assertEquals(vertex.getData(), "Hi there");
    }

    @Test
    public void equalsSameObjectTest() {
        Vertex<String> vertex = new Vertex<>("Hi there");
        Assert.assertEquals(vertex, vertex);
    }

    @Test
    public void equalsNullTest() {
        Vertex<String> vertex = new Vertex<>("Hi there");
        Assert.assertNotEquals(vertex, null);
    }

    @Test
    public void equalsDifferentTypesObjectsTest() {
        Vertex<String> vertex = new Vertex<>("Hi there");
        Assert.assertNotEquals(vertex, "Hi there");
    }

    @Test
    public void equalsDifferentDataTypesTest() {
        Vertex<String> stringVertex = new Vertex<>("123");
        Vertex<Integer> intVertex = new Vertex<>(123);
        Assert.assertNotEquals(stringVertex, intVertex);
    }

    @Test
    public void equalsTrueTest() {
        Vertex<String> vertex1 = new Vertex<>("Hi there");
        Vertex<String> vertex2 = new Vertex<>("Hi there");
        Assert.assertEquals(vertex1, vertex2);
    }

    @Test
    public void equalsFalseTest() {
        Vertex<String> vertex1 = new Vertex<>("Hi there");
        Vertex<String> vertex2 = new Vertex<>("Hi, there");
        Assert.assertNotEquals(vertex1, vertex2);
    }

    @Test
    public void hashCode1Test() {
        Vertex<String> vertex = new Vertex<>("Hi there");
        Assert.assertEquals(vertex.hashCode(), 653358757);
    }

    @Test
    public void hashCode2Test() {
        Vertex<String> vertex1 = new Vertex<>("Hi there");
        Vertex<String> vertex2 = new Vertex<>("Hi there");
        Assert.assertEquals(vertex1.hashCode(), vertex2.hashCode());
    }

    @Test
    public void hashCode3Test() {
        Vertex<String> vertex1 = new Vertex<>("Hi there");
        Vertex<String> vertex2 = new Vertex<>("Hi, there");
        Assert.assertNotEquals(vertex1.hashCode(), vertex2.hashCode());
    }
}
