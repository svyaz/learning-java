import com.github.svyaz.javalearning.matrix.Matrix;
import com.github.svyaz.javalearning.vector.Vector;
import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
    @Test
    public void constructor1Test() {
        Matrix matrix = new Matrix(2, 1);
        Assert.assertTrue(matrix.getSizes()[0] == 2 && matrix.getSizes()[1] == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor1Exception1Test() {
        new Matrix(-2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor1Exception2Test() {
        new Matrix(2, 0);
    }

    @Test
    public void constructor2Test() {
        Vector vector1 = new Vector(new double[]{1, 2});
        Vector vector2 = new Vector(new double[]{3, 4});
        Matrix matrix = new Matrix(new Vector[]{vector1, vector2});
        Assert.assertTrue(matrix.getSizes()[0] == 2 && matrix.getSizes()[1] == 2);
    }

    @Test
    public void constructor2OneRowTest() {
        Vector vector = new Vector(new double[]{1, 2});
        Matrix matrix = new Matrix(new Vector[]{vector});
        Assert.assertTrue(matrix.getSizes()[0] == 1 && matrix.getSizes()[1] == 2);
    }

    @Test
    public void constructor2DifferentLength1Test() {
        Vector vector1 = new Vector(new double[]{1});
        Vector vector2 = new Vector(new double[]{3, 4});
        Matrix matrix = new Matrix(new Vector[]{vector1, vector2});
        Assert.assertTrue(matrix.getSizes()[0] == 2 && matrix.getSizes()[1] == 2);
    }

    @Test
    public void constructor2DifferentLength2Test() {
        Vector vector1 = new Vector(new double[]{1, 2, 5});
        Vector vector2 = new Vector(new double[]{3, 4});
        Matrix matrix = new Matrix(new Vector[]{vector1, vector2});
        Assert.assertTrue(matrix.getSizes()[0] == 2 && matrix.getSizes()[1] == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor2ExceptionTest() {
        new Matrix(new Vector[]{});
    }

    @Test
    public void constructor3Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Assert.assertTrue(matrix.getSizes()[0] == 2 && matrix.getSizes()[1] == 2);
    }

    @Test
    public void constructor3OneRowTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}});
        Assert.assertTrue(matrix.getSizes()[0] == 1 && matrix.getSizes()[1] == 2);
    }

    @Test
    public void constructor3DifferentLength1Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3}, {4, 5, 6}});
        Assert.assertTrue(matrix.getSizes()[0] == 3 && matrix.getSizes()[1] == 3);
    }

    @Test
    public void constructor3DifferentLength2Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2, 3}, {4}});
        Assert.assertTrue(matrix.getSizes()[0] == 2 && matrix.getSizes()[1] == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor3ExceptionTest() {
        new Matrix(new double[][]{});
    }

    @Test
    public void constructor4Test() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(matrix1);
        Assert.assertTrue(matrix2.getSizes()[0] == 2 && matrix2.getSizes()[1] == 2);
    }

    @Test
    public void toString1Test() {
        Matrix matrix = new Matrix(2, 2);
        Assert.assertEquals("Matrix { { 0.0, 0.0 }, { 0.0, 0.0 } }", matrix.toString());
    }

    @Test
    public void toString2Test() {
        Vector vector1 = new Vector(new double[]{1, 2});
        Vector vector2 = new Vector(new double[]{3, 4});
        Matrix matrix = new Matrix(new Vector[]{vector1, vector2});
        Assert.assertEquals("Matrix { { 1.0, 2.0 }, { 3.0, 4.0 } }", matrix.toString());
    }
}
