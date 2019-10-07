package com.github.svyaz.javalearning.shapes;

import com.github.svyaz.ShapePerimeterComparator;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class ShapePerimeterComparatorTest {
    @Test
    public void constructorTest(){
        ShapePerimeterComparator shapePerimeterComparator = new ShapePerimeterComparator();
        Assert.assertNotNull(shapePerimeterComparator);
    }

    @Test
    public void comparePerimeterTest() {
        ShapePerimeterComparator shapePerimeterComparator = new ShapePerimeterComparator();
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(2);
        Shape[] shapes = {circle1, circle2};
        Arrays.sort(shapes, shapePerimeterComparator);
        Assert.assertTrue(shapes[0].equals(circle2) &&
                shapes[1].equals(circle1));
    }
}
