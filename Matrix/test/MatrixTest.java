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
    public void getRowTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Vector row = matrix.getRow(0);
        Assert.assertTrue(row.getSize() == 2 &&
                row.getComponent(0) == 1.0 && row.getComponent(1) == 2.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getRowException1Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.getRow(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getRowException2Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.getRow(2);
    }

    @Test
    public void setRowTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setRow(1, new Vector(new double[]{5, 6}));
        Vector row = matrix.getRow(1);
        Assert.assertTrue(row.getSize() == 2 &&
                row.getComponent(0) == 5.0 && row.getComponent(1) == 6.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setRowException1Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setRow(-1, new Vector(new double[]{5, 6}));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setRowException2Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setRow(2, new Vector(new double[]{5, 6}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRowException3Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setRow(1, new Vector(new double[]{5}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRowException4Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setRow(1, new Vector(new double[]{5, 6, 7}));
    }

    @Test
    public void getColumnTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Vector column = matrix.getColumn(1);
        Assert.assertTrue(column.getSize() == 2 &&
                column.getComponent(0) == 2.0 && column.getComponent(1) == 5.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getColumnException1Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.getColumn(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getColumnException2Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.getColumn(2);
    }

    @Test
    public void setColumnTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setColumn(1, new Vector(new double[]{5, 6}));
        Vector row = matrix.getColumn(1);
        Assert.assertTrue(row.getSize() == 2 &&
                row.getComponent(0) == 5.0 && row.getComponent(1) == 6.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setColumnException1Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setColumn(-1, new Vector(new double[]{5, 6}));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setColumnException2Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setColumn(2, new Vector(new double[]{5, 6}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setColumnException3Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setColumn(1, new Vector(new double[]{5}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setColumnException4Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.setColumn(1, new Vector(new double[]{5, 6, 7}));
    }

    @Test
    public void transposeTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}, {5, 6}});
        matrix.transpose();
        Assert.assertTrue(matrix.getSizes()[0] == 2 && matrix.getSizes()[1] == 3 &&
                matrix.getRow(0).getComponent(0) == 1.0 &&
                matrix.getRow(0).getComponent(1) == 3.0 &&
                matrix.getRow(0).getComponent(2) == 5.0 &&
                matrix.getRow(1).getComponent(0) == 2.0 &&
                matrix.getRow(1).getComponent(1) == 4.0 &&
                matrix.getRow(1).getComponent(2) == 6.0);
    }

    @Test
    public void multiplicationTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.multiplication(2);
        Assert.assertTrue(matrix.getRow(0).getComponent(0) == 2.0 &&
                matrix.getRow(0).getComponent(1) == 4.0 &&
                matrix.getRow(1).getComponent(0) == 6.0 &&
                matrix.getRow(1).getComponent(1) == 8.0);
    }

    @Test
    public void getDeterminant1Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Assert.assertEquals(matrix.getDeterminant(), -2.0, 0.0);
    }

    @Test
    public void getDeterminant2Test() {
        Matrix matrix = new Matrix(new double[][]{{3.0, 5.0, 2.0}, {8.0, 4.0, 3.0}, {3.0, 7.0, 2.0}});
        Assert.assertEquals(matrix.getDeterminant(), 14.0, 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void getDeterminantExceptionTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        matrix.getDeterminant();
    }

    @Test
    public void multiplicationByColumnTest() {
        Matrix matrix = new Matrix(new double[][]{{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}});
        Vector column = new Vector(new double[]{1, 2, -1});
        Vector result = matrix.multiplicationByColumn(column);
        Assert.assertTrue(result.getSize() == 3 &&
                result.getComponent(0) == 10.0 &&
                result.getComponent(1) == -3.0 &&
                result.getComponent(2) == -2.0);
    }

    @Test(expected = ArithmeticException.class)
    public void multiplicationByColumnExceptionTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Vector vector = new Vector(new double[]{7, 8});
        matrix.multiplicationByColumn(vector);
    }

    @Test
    public void multiplicationByRowTest() {
        Matrix matrix = new Matrix(new double[][]{{1}, {2}});
        Vector row = new Vector(new double[]{3, 4});
        Matrix result = matrix.multiplicationByRow(row);
        Assert.assertTrue(result.getSizes()[0] == 2 && result.getSizes()[1] == 2 &&
                result.getRow(0).getComponent(0) == 3.0 &&
                result.getRow(0).getComponent(1) == 4.0 &&
                result.getRow(1).getComponent(0) == 6.0 &&
                result.getRow(1).getComponent(1) == 8.0);
    }

    @Test(expected = ArithmeticException.class)
    public void multiplicationByRowExceptionTest() {
        Matrix matrix = new Matrix(new double[][]{{1}, {2}});
        Vector row = new Vector(new double[]{3, 4, 5});
        matrix.multiplicationByRow(row);
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

    @Test
    public void equalsSameObjectTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Assert.assertEquals(matrix, matrix);
    }

    @Test
    public void equalsNullObjectTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Assert.assertNotEquals(matrix, null);
    }

    @Test
    public void equalsDifferentClassesTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Vector vector = new Vector(new double[]{1, 2});
        Assert.assertNotEquals(matrix, vector);
    }

    @Test
    public void equalsDifferentObjectsTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 2}, {3, 5}});
        Assert.assertNotEquals(matrix1, matrix2);
    }

    @Test
    public void equalsEqualObjectsTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Assert.assertEquals(matrix1, matrix2);
    }

    @Test
    public void hashCode1Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Assert.assertEquals(matrix.hashCode(), -990348319);
    }

    @Test
    public void hashCode2Test() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Assert.assertEquals(matrix1.hashCode(), matrix2.hashCode());
    }

    @Test
    public void hashCode3Test() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 2}, {3, 5}});
        Assert.assertNotEquals(matrix1.hashCode(), matrix2.hashCode());
    }
}
