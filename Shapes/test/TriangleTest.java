import com.github.svyaz.javalearning.shapes.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void constructorTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertTrue(triangle.getX1() == 0 && triangle.getY1() == 0 &&
                triangle.getX2() == 0 && triangle.getY2() == 3 &&
                triangle.getX3() == 4 && triangle.getY3() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest() {
        new Triangle(0, 0, 0, 3, 0, 5);
    }

    @Test
    public void getX1Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getX1(), 0, EPSILON);
    }

    @Test
    public void setX1Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setX1(-3);
        Assert.assertEquals(triangle.getX1(), -3, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setX1ExceptionTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setX1(4);
    }

    @Test
    public void getY1Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getY1(), 0, EPSILON);
    }

    @Test
    public void setY1Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setY1(-3);
        Assert.assertEquals(triangle.getY1(), -3, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setY1ExceptionTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setY1(3);
    }

    @Test
    public void getX2Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getX2(), 0, EPSILON);
    }

    @Test
    public void setX2Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setX2(4);
        Assert.assertEquals(triangle.getX2(), 4, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setX2ExceptionTest() {
        Triangle triangle = new Triangle(0, 0, 3, 0, 0, 4);
        triangle.setX2(0);
    }

    @Test
    public void getY2Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getY2(), 3, EPSILON);
    }

    @Test
    public void setY2Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setY2(4);
        Assert.assertEquals(triangle.getY2(), 4, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setY2ExceptionTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setY2(0);
    }

    @Test
    public void getX3Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getX3(), 4, EPSILON);
    }

    @Test
    public void setX3Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setX3(5);
        Assert.assertEquals(triangle.getX3(), 5, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setX3ExceptionTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setX3(0);
    }

    @Test
    public void getY3Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getY3(), 0, EPSILON);
    }

    @Test
    public void setY3Test() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        triangle.setY3(4);
        Assert.assertEquals(triangle.getY3(), 4, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setY3ExceptionTest() {
        Triangle triangle = new Triangle(0, 0, 3, 0, 0, 4);
        triangle.setY3(0);
    }

    @Test
    public void getWidthTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getWidth(), 4, EPSILON);
    }

    @Test
    public void getHeightTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getHeight(), 3, EPSILON);
    }

    @Test
    public void getAreaTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getArea(), 6, EPSILON);
    }

    @Test
    public void getPerimeterTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.getPerimeter(), 12, EPSILON);
    }

    @Test
    public void toStringTest() {
        Triangle triangle = new Triangle(0, 0, 0, 3, 4, 0);
        Assert.assertEquals(triangle.toString(),
                "Triangle, sides: [3.00, 5.00, 4.00], area: 6.00, perimeter: 12.00");
    }
}
