package com.github.svyaz.javalearning.shapes;

import org.junit.Assert;
import org.junit.Test;

public class CircleTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void constructorTest() {
        Circle circle = new Circle(2);
        Assert.assertEquals(circle.getRadius(), 2, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest() {
        new Circle(-2);
    }

    @Test
    public void getRadiusTest() {
        Circle circle = new Circle(3);
        Assert.assertEquals(circle.getRadius(), 3, EPSILON);
    }

    @Test
    public void setRadiusTest() {
        Circle circle = new Circle(2);
        circle.setRadius(3);
        Assert.assertEquals(circle.getRadius(), 3, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRadiusExceptionTest() {
        Circle circle = new Circle(2);
        circle.setRadius(-2);
    }

    @Test
    public void getWidthTest() {
        Circle circle = new Circle(2);
        Assert.assertEquals(circle.getWidth(), 4, EPSILON);
    }

    @Test
    public void getHeightTest() {
        Circle circle = new Circle(2);
        Assert.assertEquals(circle.getHeight(), 4, EPSILON);
    }

    @Test
    public void getAreaTest() {
        Circle circle = new Circle(2);
        Assert.assertEquals(circle.getArea(), 12.566370614359172, EPSILON);
    }

    @Test
    public void getPerimeterTest() {
        Circle circle = new Circle(3);
        Assert.assertEquals(circle.getPerimeter(), 18.84955592153876, EPSILON);
    }

    @Test
    public void toStringTest() {
        Circle circle = new Circle(3);
        Assert.assertEquals(circle.toString(),
                "Circle, radius: 3.00, area: 28.27, perimeter: 18.85");
    }

    @Test
    public void equalsSameObjectTest() {
        Circle circle = new Circle(3);
        Assert.assertTrue(circle.equals(circle));
    }

    @Test
    public void equalsNullObjectTest() {
        Circle circle = new Circle(3);
        Assert.assertFalse(circle.equals(null));
    }

    @Test
    public void equalsDifferentClassesTest() {
        Circle circle = new Circle(3);
        Rectangle rectangle = new Rectangle(2, 3);
        Assert.assertFalse(circle.equals(rectangle));
    }

    @Test
    public void equalsEqualObjectsTest() {
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(3);
        Assert.assertTrue(circle1.equals(circle2));
    }

    @Test
    public void hashCodeOkTest() {
        Circle circle = new Circle(3);
        Assert.assertEquals(circle.hashCode(), 1074266112);
    }

    @Test
    public void hashCodeEqualObjectsTest() {
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(3);
        Assert.assertEquals(circle1.hashCode(), circle2.hashCode());
    }
}
