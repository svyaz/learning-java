import com.github.svyaz.javalearning.vector.Vector;
import org.junit.Assert;
import org.junit.Test;

public class VectorTest {
    @Test
    public void constructor1Test() {
        Vector vector = new Vector(2);
        Assert.assertTrue(vector.getSize() == 2 &&
                vector.getComponent(0) == 0.0 &&
                vector.getComponent(1) == 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor1ExceptionTest() {
        new Vector(-2);
    }

    @Test
    public void constructor2Variant1Test() {
        Vector vector = new Vector(2, new double[]{});
        Assert.assertTrue(vector.getSize() == 2 &&
                vector.getComponent(0) == 0.0 &&
                vector.getComponent(1) == 0.0);
    }

    @Test
    public void constructor2Variant2Test() {
        Vector vector = new Vector(2, new double[]{1});
        Assert.assertTrue(vector.getSize() == 2 &&
                vector.getComponent(0) == 1.0 &&
                vector.getComponent(1) == 0.0);
    }

    @Test
    public void constructor2Variant3Test() {
        Vector vector = new Vector(2, new double[]{1, 2});
        Assert.assertTrue(vector.getSize() == 2 &&
                vector.getComponent(0) == 1.0 &&
                vector.getComponent(1) == 2.0);
    }

    @Test
    public void constructor2Variant4Test() {
        Vector vector = new Vector(2, new double[]{1, 2, 3});
        Assert.assertTrue(vector.getSize() == 2 &&
                vector.getComponent(0) == 1.0 &&
                vector.getComponent(1) == 2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor2ExceptionTest() {
        new Vector(0, new double[]{1, 2, 3, 4, 5});
    }

    @Test
    public void constructor3Variant1Test() {
        Vector vector = new Vector(new double[]{1});
        Assert.assertTrue(vector.getSize() == 1 &&
                vector.getComponent(0) == 1.0);
    }

    @Test
    public void constructor3Variant2Test() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        Assert.assertTrue(vector.getSize() == 3 &&
                vector.getComponent(0) == 1.0 &&
                vector.getComponent(1) == 2.0 &&
                vector.getComponent(2) == 3.0);
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
                vector1.getComponent(0) == vector2.getComponent(0) &&
                vector1.getComponent(1) == vector2.getComponent(1));
    }

    @Test
    public void getComponentTest() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        Assert.assertEquals(vector.getComponent(1), 2.0, 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getComponentException1Test() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        vector.getComponent(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getComponentException2Test() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        vector.getComponent(3);
    }

    @Test
    public void setComponentTest() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        vector.setComponent(0, 15.6);
        Assert.assertEquals(vector.getComponent(0), 15.6, 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setComponentException1Test() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        vector.setComponent(-1, 12.9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setComponentException2Test() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        vector.setComponent(3, 12.9);
    }

    @Test
    public void getSizeTest() {
        Vector vector = new Vector(new double[]{1, 2, 3, 4, 5});
        Assert.assertEquals(vector.getSize(), 5);
    }

    @Test
    public void getLengthTest() {
        Vector vector = new Vector(new double[]{1, 2, 2});
        Assert.assertEquals(vector.getLength(), 3.0, 0.0);
    }

    @Test
    public void toStringTest() {
        Vector vector = new Vector(new double[]{1, 2});
        Assert.assertEquals(vector.toString(), "Vector {1.0, 2.0}");
    }

    @Test
    public void equalsSameObjectTest() {
        Vector vector = new Vector(new double[]{1, 2});
        Assert.assertEquals(vector, vector);
    }

    @Test
    public void equalsNullObjectTest() {
        Vector vector = new Vector(new double[]{1, 2});
        Assert.assertNotEquals(vector, null);
    }

    @Test
    public void equalsDifferentClassesTest() {
        Vector vector = new Vector(new double[]{1, 2});
        String string = "test";
        Assert.assertNotEquals(vector, string);
    }

    @Test
    public void equalsDifferentDimensionsTest() {
        Vector vector1 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector2 = new Vector(new double[]{1, 2, 3});
        Assert.assertNotEquals(vector1, vector2);
    }

    @Test
    public void equalsEqualObjectsTest() {
        Vector vector1 = new Vector(new double[]{1, 2, 3});
        Vector vector2 = new Vector(new double[]{1, 2, 3});
        Assert.assertEquals(vector1, vector2);
    }

    @Test
    public void hashCode1Test() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        Assert.assertEquals(vector.hashCode(), 66614367);
    }

    @Test
    public void hashCode2Test() {
        Vector vector1 = new Vector(new double[]{1, 2, 3, 4, 5});
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4, 5});
        Assert.assertEquals(vector1.hashCode(), vector2.hashCode());
    }

    @Test
    public void addTest() {
        Vector vector1 = new Vector(new double[]{1, 3, -1});
        Vector vector2 = new Vector(new double[]{4, 1, -5});
        vector1.add(vector2);
        Assert.assertTrue(vector1.getComponent(0) == 5.0 &&
                vector1.getComponent(1) == 4.0 &&
                vector1.getComponent(2) == -6.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addExceptionTest() {
        Vector vector1 = new Vector(new double[]{1, 3});
        Vector vector2 = new Vector(new double[]{4, 1, 2});
        vector1.add(vector2);
    }

    @Test
    public void subtractTest() {
        Vector vector1 = new Vector(new double[]{1, 3, -1});
        Vector vector2 = new Vector(new double[]{4, 1, -5});
        vector1.subtract(vector2);
        Assert.assertTrue(vector1.getComponent(0) == -3.0 &&
                vector1.getComponent(1) == 2.0 &&
                vector1.getComponent(2) == 4.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractExceptionTest() {
        Vector vector1 = new Vector(new double[]{1, 3});
        Vector vector2 = new Vector(new double[]{4, 1, 2});
        vector1.subtract(vector2);
    }

    @Test
    public void multiplicationTest() {
        Vector vector = new Vector(new double[]{1, 3, -1});
        vector.multiplication(2);
        Assert.assertTrue(vector.getComponent(0) == 2.0 &&
                vector.getComponent(1) == 6.0 &&
                vector.getComponent(2) == -2.0);
    }

    @Test
    public void reverseTest() {
        Vector vector = new Vector(new double[]{1, 3, -1});
        vector.reverse();
        Assert.assertTrue(vector.getComponent(0) == -1.0 &&
                vector.getComponent(1) == -3.0 &&
                vector.getComponent(2) == 1.0);
    }

    @Test
    public void staticAddTest() {
        Vector vector1 = new Vector(new double[]{1, 2});
        Vector vector2 = new Vector(new double[]{1, 2});
        Vector vector3 = Vector.add(vector1, vector2);
        Assert.assertTrue(!vector3.equals(vector1) && !vector3.equals(vector2) &&
                vector3.getComponent(0) == 2.0 && vector3.getComponent(1) == 4.0);
    }

    @Test
    public void staticAddDifferentLengthTest() {
        Vector vector1 = new Vector(new double[]{1, 2});
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector3 = Vector.add(vector1, vector2);
        Assert.assertTrue(!vector3.equals(vector1) && !vector3.equals(vector2) &&
                vector3.getComponent(0) == 2.0 && vector3.getComponent(1) == 4.0 &&
                vector3.getComponent(2) == 3.0 && vector3.getComponent(3) == 4.0);
    }

    @Test
    public void staticSubtractTest() {
        Vector vector1 = new Vector(new double[]{2, 3});
        Vector vector2 = new Vector(new double[]{1, 2});
        Vector vector3 = Vector.subtract(vector1, vector2);
        Assert.assertTrue(!vector3.equals(vector1) && !vector3.equals(vector2) &&
                vector3.getComponent(0) == 1.0 && vector3.getComponent(1) == 1.0);
    }

    @Test
    public void staticSubtractDifferentLengthTest() {
        Vector vector1 = new Vector(new double[]{1, 2});
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector3 = Vector.subtract(vector1, vector2);
        Assert.assertTrue(!vector3.equals(vector1) && !vector3.equals(vector2) &&
                vector3.getComponent(0) == 0.0 && vector3.getComponent(1) == 0.0 &&
                vector3.getComponent(2) == -3.0 && vector3.getComponent(3) == -4.0);
    }

    @Test
    public void staticScalarMultiplicationTest() {
        Vector vector1 = new Vector(new double[]{2, 3});
        Vector vector2 = new Vector(new double[]{1, 2});
        Assert.assertEquals(Vector.scalarMultiplication(vector1, vector2), 8.0, 0.0);
    }

    @Test
    public void staticScalarMultiplicationDifferentLengthTest() {
        Vector vector1 = new Vector(new double[]{1, 2});
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4});
        Assert.assertEquals(Vector.scalarMultiplication(vector1, vector2), 5.0, 0.0);
    }
}
