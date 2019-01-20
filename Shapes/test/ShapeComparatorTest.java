import com.github.svyaz.javalearning.shapes.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ShapeComparatorTest {
    @Test
    public void constructorAreaTest() {
        ShapeComparator shapeComparator = new ShapeComparator(ShapeCompareType.AREA);
        Assert.assertNotNull(shapeComparator);
    }

    @Test
    public void constructorPerimeterTest() {
        ShapeComparator shapeComparator = new ShapeComparator(ShapeCompareType.PERIMETER);
        Assert.assertNotNull(shapeComparator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorUnknownTest() {
        new ShapeComparator(ShapeCompareType.valueOf("UNKNOWN"));
    }

    @Test
    public void compareAreaTest() {
        ShapeComparator shapeComparator = new ShapeComparator(ShapeCompareType.AREA);
        Square square1 = new Square(3);
        Square square2 = new Square(2);
        Shape[] shapes = {square1, square2};
        Arrays.sort(shapes, shapeComparator);
        Assert.assertTrue(shapes[0].equals(square2) &&
                shapes[1].equals(square1));
    }

    @Test
    public void comparePerimeterTest() {
        ShapeComparator shapeComparator = new ShapeComparator(ShapeCompareType.PERIMETER);
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(2);
        Shape[] shapes = {circle1, circle2};
        Arrays.sort(shapes, shapeComparator);
        Assert.assertTrue(shapes[0].equals(circle2) &&
                shapes[1].equals(circle1));
    }
}
