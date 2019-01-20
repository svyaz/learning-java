import com.github.svyaz.javalearning.shapes.*;
import org.junit.Assert;
import org.junit.Test;

public class SquareTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void constructorTest() {
        Square square = new Square(2);
        Assert.assertEquals(square.getSide(), 2, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest() {
        new Square(-2);
    }

    @Test
    public void getSideTest() {
        Square square = new Square(5);
        Assert.assertEquals(square.getSide(), 5, EPSILON);
    }

    @Test
    public void setSideTest() {
        Square square = new Square(3);
        square.setSide(4);
        Assert.assertEquals(square.getSide(), 4, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSideExceptionTest(){
        Square square = new Square(2);
        square.setSide(0);
    }

    @Test
    public void getWidthTest() {
        Square square = new Square(2);
        Assert.assertEquals(square.getWidth(), 2, EPSILON);
    }

    @Test
    public void getHeightTest() {
        Square square = new Square(2);
        Assert.assertEquals(square.getHeight(), 2, EPSILON);
    }

    @Test
    public void getAreaTest() {
        Square square = new Square(2);
        Assert.assertEquals(square.getArea(), 4, EPSILON);
    }

    @Test
    public void getPerimeterTest() {
        Square square = new Square(2);
        Assert.assertEquals(square.getPerimeter(), 8, EPSILON);
    }

    @Test
    public void toStringTest() {
        Square square = new Square(2);
        Assert.assertEquals(square.toString(),
                "Square, side: 2.00, area: 4.00, perimeter: 8.00");
    }

    @Test
    public void equalsSameObjectTest() {
        Square square = new Square(3);
        Assert.assertTrue(square.equals(square));
    }

    @Test
    public void equalsNullObjectTest() {
        Square square = new Square(3);
        Assert.assertFalse(square.equals(null));
    }

    @Test
    public void equalsDifferentClassesTest() {
        Square square = new Square(3);
        Circle circle = new Circle(3);
        Assert.assertFalse(square.equals(circle));
    }

    @Test
    public void equalsEqualObjectsTest() {
        Square square1 = new Square(3);
        Square square2 = new Square(3);
        Assert.assertTrue(square1.equals(square2));
    }
}
