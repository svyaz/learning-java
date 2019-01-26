import com.github.svyaz.javalearning.matrix.Matrix;
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
}
