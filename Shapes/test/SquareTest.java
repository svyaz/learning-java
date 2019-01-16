import com.github.svyaz.javalearning.shapes.Square;
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
}
