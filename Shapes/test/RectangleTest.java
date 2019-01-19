import com.github.svyaz.javalearning.shapes.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void constructorTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        Assert.assertTrue(rectangle.getWidth() == 2 && rectangle.getHeight() == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest() {
        new Rectangle(-2, -3);
    }

    @Test
    public void getWidthTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        Assert.assertEquals(rectangle.getWidth(), 2, EPSILON);
    }

    @Test
    public void setWidthTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        rectangle.setWidth(2.5);
        Assert.assertEquals(rectangle.getWidth(), 2.5, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setWidthExceptionTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        rectangle.setWidth(-0.5);
    }

    @Test
    public void getHeightTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        Assert.assertEquals(rectangle.getHeight(), 3, EPSILON);
    }

    @Test
    public void setHeightTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        rectangle.setHeight(2.5);
        Assert.assertEquals(rectangle.getHeight(), 2.5, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHeightExceptionTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        rectangle.setHeight(-0.5);
    }

    @Test
    public void getAreaTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        Assert.assertEquals(rectangle.getArea(), 6, EPSILON);
    }

    @Test
    public void getPerimeterTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        Assert.assertEquals(rectangle.getPerimeter(), 10, EPSILON);
    }

    @Test
    public void toStringTest() {
        Rectangle rectangle = new Rectangle(2, 3);
        Assert.assertEquals(rectangle.toString(),
                "Rectangle, width: 2.00, height: 3.00, area: 6.00, perimeter: 10.00");
    }
}
