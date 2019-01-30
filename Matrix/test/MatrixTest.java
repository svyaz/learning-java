import com.github.svyaz.javalearning.matrix.Matrix;
import com.github.svyaz.javalearning.vector.Vector;
import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
    @Test
    public void constructor1Test() {
        Matrix matrix = new Matrix(2, 1);
        Assert.assertTrue(matrix.getRowsCount() == 2 && matrix.getColumnsCount() == 1);
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
        Assert.assertTrue(matrix.getRowsCount() == 2 && matrix.getColumnsCount() == 2);
    }

    @Test
    public void constructor2OneRowTest() {
        Vector vector = new Vector(new double[]{1, 2});
        Matrix matrix = new Matrix(new Vector[]{vector});
        Assert.assertTrue(matrix.getRowsCount() == 1 && matrix.getColumnsCount() == 2);
    }

    @Test
    public void constructor2DifferentLength1Test() {
        Vector vector1 = new Vector(new double[]{1});
        Vector vector2 = new Vector(new double[]{3, 4});
        Matrix matrix = new Matrix(new Vector[]{vector1, vector2});
        Assert.assertTrue(matrix.getRowsCount() == 2 && matrix.getColumnsCount() == 2);
    }

    @Test
    public void constructor2DifferentLength2Test() {
        Vector vector1 = new Vector(new double[]{1, 2, 5});
        Vector vector2 = new Vector(new double[]{3, 4});
        Matrix matrix = new Matrix(new Vector[]{vector1, vector2});
        Assert.assertTrue(matrix.getRowsCount() == 2 && matrix.getColumnsCount() == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor2ExceptionTest() {
        new Matrix(new Vector[]{});
    }

    @Test
    public void constructor3Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Assert.assertTrue(matrix.getRowsCount() == 2 && matrix.getColumnsCount() == 2);
    }

    @Test
    public void constructor3OneRowTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}});
        Assert.assertTrue(matrix.getRowsCount() == 1 && matrix.getColumnsCount() == 2);
    }

    @Test
    public void constructor3DifferentLength1Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3}, {4, 5, 6}});
        Assert.assertTrue(matrix.getRowsCount() == 3 && matrix.getColumnsCount() == 3);
    }

    @Test
    public void constructor3DifferentLength2Test() {
        Matrix matrix = new Matrix(new double[][]{{1, 2, 3}, {4}});
        Assert.assertTrue(matrix.getRowsCount() == 2 && matrix.getColumnsCount() == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor3Exception1Test() {
        new Matrix(new double[][]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor3Exception2Test() {
        double[] d1 = new double[0];
        double[] d2 = new double[0];
        new Matrix(new double[][]{d1, d2});
    }

    @Test
    public void constructor4Test() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(matrix1);
        Assert.assertTrue(matrix2.getRowsCount() == 2 && matrix2.getColumnsCount() == 2);
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
        Assert.assertTrue(matrix.getRowsCount() == 2 && matrix.getColumnsCount() == 3 &&
                matrix.getRow(0).getComponent(0) == 1.0 &&
                matrix.getRow(0).getComponent(1) == 3.0 &&
                matrix.getRow(0).getComponent(2) == 5.0 &&
                matrix.getRow(1).getComponent(0) == 2.0 &&
                matrix.getRow(1).getComponent(1) == 4.0 &&
                matrix.getRow(1).getComponent(2) == 6.0);
    }

    @Test
    public void multiplyTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        matrix.multiply(2);
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
    public void multiplyByColumnTest() {
        Matrix matrix = new Matrix(new double[][]{{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}});
        Vector column = new Vector(new double[]{1, 2, -1});
        Vector result = matrix.multiplyByColumn(column);
        Assert.assertTrue(result.getSize() == 3 &&
                result.getComponent(0) == 10.0 &&
                result.getComponent(1) == -3.0 &&
                result.getComponent(2) == -2.0);
    }

    @Test(expected = ArithmeticException.class)
    public void multiplyByColumnExceptionTest() {
        Matrix matrix = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Vector vector = new Vector(new double[]{7, 8});
        matrix.multiplyByColumn(vector);
    }

    @Test
    public void multiplyByRowTest() {
        Matrix matrix = new Matrix(new double[][]{{1}, {2}});
        Vector row = new Vector(new double[]{3, 4});
        matrix.multiplyByRow(row);
        Assert.assertTrue(matrix.getRowsCount() == 2 && matrix.getColumnsCount() == 2 &&
                matrix.getRow(0).getComponent(0) == 3.0 &&
                matrix.getRow(0).getComponent(1) == 4.0 &&
                matrix.getRow(1).getComponent(0) == 6.0 &&
                matrix.getRow(1).getComponent(1) == 8.0);
    }

    @Test(expected = ArithmeticException.class)
    public void multiplyByRowExceptionTest() {
        Matrix matrix = new Matrix(new double[][]{{1}, {2}});
        Vector row = new Vector(new double[]{3, 4, 5});
        matrix.multiplyByRow(row);
    }

    @Test
    public void addTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6}, {7, 8}});
        matrix1.add(matrix2);
        Assert.assertTrue(matrix1.getRow(0).getComponent(0) == 6.0 &&
                matrix1.getRow(0).getComponent(1) == 8.0 &&
                matrix1.getRow(1).getComponent(0) == 10.0 &&
                matrix1.getRow(1).getComponent(1) == 12.0);
    }

    @Test(expected = ArithmeticException.class)
    public void addExceptionTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6, 7}, {8, 9, 10}});
        matrix1.add(matrix2);
    }

    @Test
    public void subtractTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6}, {7, 8}});
        matrix1.subtract(matrix2);
        Assert.assertTrue(matrix1.getRow(0).getComponent(0) == -4.0 &&
                matrix1.getRow(0).getComponent(1) == -4.0 &&
                matrix1.getRow(1).getComponent(0) == -4.0 &&
                matrix1.getRow(1).getComponent(1) == -4.0);
    }

    @Test(expected = ArithmeticException.class)
    public void subtractExceptionTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6, 7}, {8, 9, 10}});
        matrix1.subtract(matrix2);
    }

    @Test
    public void staticAddTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6}, {7, 8}});
        Matrix result = Matrix.add(matrix1, matrix2);
        Assert.assertTrue(!result.equals(matrix1) && !result.equals(matrix2) &&
                result.getRow(0).getComponent(0) == 6.0 &&
                result.getRow(0).getComponent(1) == 8.0 &&
                result.getRow(1).getComponent(0) == 10.0 &&
                result.getRow(1).getComponent(1) == 12.0);
    }

    @Test(expected = ArithmeticException.class)
    public void staticAddExceptionTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6, 7}, {8, 9, 10}});
        Matrix.add(matrix1, matrix2);
    }

    @Test
    public void staticSubtractTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6}, {7, 8}});
        Matrix result = Matrix.subtract(matrix1, matrix2);
        Assert.assertTrue(!result.equals(matrix1) && !result.equals(matrix2) &&
                result.getRow(0).getComponent(0) == -4.0 &&
                result.getRow(0).getComponent(1) == -4.0 &&
                result.getRow(1).getComponent(0) == -4.0 &&
                result.getRow(1).getComponent(1) == -4.0);
    }

    @Test(expected = ArithmeticException.class)
    public void staticSubtractExceptionTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6, 7}, {8, 9, 10}});
        Matrix.subtract(matrix1, matrix2);
    }

    @Test
    public void staticMultiply1Test() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 1}, {0, 1, 2}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 0}, {0, 1}, {1, 1}});
        Matrix result = Matrix.multiply(matrix1, matrix2);
        Assert.assertTrue(result.getRowsCount() == 2 && result.getColumnsCount() == 2 &&
                result.getRow(0).getComponent(0) == 2.0 &&
                result.getRow(0).getComponent(1) == 3.0 &&
                result.getRow(1).getComponent(0) == 2.0 &&
                result.getRow(1).getComponent(1) == 3.0);
    }

    @Test
    public void staticMultiply2Test() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 1}, {0, 1, 2}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 0}, {0, 1}, {1, 1}});
        Matrix result = Matrix.multiply(matrix2, matrix1);
        Assert.assertTrue(result.getRowsCount() == 3 && result.getColumnsCount() == 3 &&
                result.getRow(0).getComponent(0) == 1.0 &&
                result.getRow(0).getComponent(1) == 2.0 &&
                result.getRow(0).getComponent(2) == 1.0 &&
                result.getRow(1).getComponent(0) == 0.0 &&
                result.getRow(1).getComponent(1) == 1.0 &&
                result.getRow(1).getComponent(2) == 2.0 &&
                result.getRow(2).getComponent(0) == 1.0 &&
                result.getRow(2).getComponent(1) == 3.0 &&
                result.getRow(2).getComponent(2) == 3.0);
    }

    @Test
    public void staticMultiply3Test() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 2, 3, 4}, {5, 6, 7, 8}});
        Matrix result = Matrix.multiply(matrix1, matrix2);
        Assert.assertTrue(result.getRowsCount() == 2 && result.getColumnsCount() == 4 &&
                result.getRow(0).getComponent(0) == 11.0 &&
                result.getRow(0).getComponent(1) == 14.0 &&
                result.getRow(0).getComponent(2) == 17.0 &&
                result.getRow(0).getComponent(3) == 20.0 &&
                result.getRow(1).getComponent(0) == 23.0 &&
                result.getRow(1).getComponent(1) == 30.0 &&
                result.getRow(1).getComponent(2) == 37.0 &&
                result.getRow(1).getComponent(3) == 44.0);
    }

    @Test(expected = ArithmeticException.class)
    public void staticMultiplyExceptionTest() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 1}, {0, 1, 2}, {3, 0, 2}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 0}, {0, 1}});
        Matrix.multiply(matrix1, matrix2);
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
