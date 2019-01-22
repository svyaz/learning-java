import com.github.svyaz.javalearning.vector.Vector;
import org.junit.Assert;
import org.junit.Test;

public class VectorTest {
    @Test
    public void constructor1Test() {
        Vector vector = new Vector(2);
        Assert.assertTrue(vector.getComponents().length == 2 &&
                vector.getComponents()[0] == 0.0 &&
                vector.getComponents()[1] == 0.0
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor1ExceptionTest() {
        new Vector(-2);
    }

    @Test
    public void constructor2Variant1Test() {
        Vector vector = new Vector(2, new double[]{});
        Assert.assertTrue(vector.getComponents().length == 2 &&
                vector.getComponents()[0] == 0.0 &&
                vector.getComponents()[1] == 0.0
        );
    }

    @Test
    public void constructor2Variant2Test() {
        Vector vector = new Vector(2, new double[]{1});
        Assert.assertTrue(vector.getComponents().length == 2 &&
                vector.getComponents()[0] == 1.0 &&
                vector.getComponents()[1] == 0.0
        );
    }

    @Test
    public void constructor2Variant3Test() {
        Vector vector = new Vector(2, new double[]{1, 2});
        Assert.assertTrue(vector.getComponents().length == 2 &&
                vector.getComponents()[0] == 1.0 &&
                vector.getComponents()[1] == 2.0
        );
    }

    @Test
    public void constructor2Variant4Test() {
        Vector vector = new Vector(2, new double[]{1, 2, 3});
        Assert.assertTrue(vector.getComponents().length == 2 &&
                vector.getComponents()[0] == 1.0 &&
                vector.getComponents()[1] == 2.0
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor2ExceptionTest() {
        new Vector(0, new double[]{1, 2, 3, 4, 5});
    }

    @Test
    public void constructor3Variant1Test() {
        Vector vector = new Vector(new double[]{1});
        Assert.assertTrue(vector.getComponents().length == 1 &&
                vector.getComponents()[0] == 1.0
        );
    }

    @Test
    public void constructor3Variant2Test() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        Assert.assertTrue(vector.getComponents().length == 3 &&
                vector.getComponents()[0] == 1.0 &&
                vector.getComponents()[1] == 2.0 &&
                vector.getComponents()[2] == 3.0
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor3ExceptionTest() {
        new Vector(new double[]{});
    }

    @Test
    public void constructor4Test() {
        Vector vector1 = new Vector(new double[]{1, 2});
        Vector vector2 = new Vector(vector1);
        Assert.assertTrue(vector1 != vector2 &&
                vector1.getComponents() != vector2.getComponents() &&
                vector1.getComponents()[0] == vector2.getComponents()[0] &&
                vector1.getComponents()[1] == vector2.getComponents()[1]
        );
    }

    @Test
    public void getComponentsTest() {
        Vector vector = new Vector(2, new double[]{-1, 5});
        Assert.assertTrue(vector.getComponents().length == 2 &&
                vector.getComponents()[0] == -1.0 &&
                vector.getComponents()[1] == 5.0
        );
    }

    @Test
    public void setComponentsTest() {
        Vector vector = new Vector(new double[]{1, 2});
        vector.setComponents(new double[]{3, 4});
        Assert.assertTrue(vector.getComponents()[0] == 3.0 &&
                vector.getComponents()[1] == 4.0
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void setComponentsExceptionTest() {
        Vector vector = new Vector(new double[]{1, 2});
        vector.setComponents(new double[]{3, 4, 5});
    }

    @Test
    public void getSizeTest() {
        Vector vector = new Vector(new double[]{1, 2, 3, 4, 5});
        Assert.assertEquals(vector.getSize(), 5);
    }

    @Test
    public void toStringTest() {
        Vector vector = new Vector(new double[]{1, 2});
        Assert.assertEquals(vector.toString(),
                "Vector {1.0, 2.0}");
    }
}
