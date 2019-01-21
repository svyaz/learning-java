import com.github.svyaz.ShapeAreaComparator;
import com.github.svyaz.javalearning.shapes.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class ShapeAreaComparatorTest {
    @Test
    public void constructorAreaTest() {
        ShapeAreaComparator shapeAreaComparator = new ShapeAreaComparator();
        Assert.assertNotNull(shapeAreaComparator);
    }

    @Test
    public void compareAreaTest() {
        ShapeAreaComparator shapeAreaComparator = new ShapeAreaComparator();
        Square square1 = new Square(3);
        Square square2 = new Square(2);
        Shape[] shapes = {square1, square2};
        Arrays.sort(shapes, shapeAreaComparator);
        Assert.assertTrue(shapes[0].equals(square2) &&
                shapes[1].equals(square1));
    }
}
