import com.github.svyaz.javalearning.range.Range;
import org.junit.Assert;
import org.junit.Test;

public class RangeTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void constructorTest() {
        Range range = new Range(4, 5);
        Assert.assertEquals(1.0, range.getLength(), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest() {
        new Range(5, 4);
    }

    @Test
    public void getFromTest() {
        Range range = new Range(4, 5);
        Assert.assertEquals(4.0, range.getFrom(), EPSILON);
    }

    @Test
    public void getToTest() {
        Range range = new Range(4, 5);
        Assert.assertEquals(5.0, range.getTo(), EPSILON);
    }

    @Test
    public void setFromTest() {
        Range range = new Range(4, 5);
        range.setFrom(3);
        Assert.assertEquals(2.0, range.getLength(), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFromExceptionTest() {
        Range range = new Range(4, 5);
        range.setFrom(6);
    }

    @Test
    public void setToTest() {
        Range range = new Range(4, 5);
        range.setTo(6);
        Assert.assertEquals(2.0, range.getLength(), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setToExceptionTest() {
        Range range = new Range(4, 5);
        range.setTo(3);
    }

    @Test
    public void toStringTest() {
        Range range = new Range(4, 5);
        Assert.assertEquals(range.toString(), "[4.0, 5.0]");
    }

    @Test
    public void isInsideTrueTest() {
        Range range = new Range(4, 5);
        Assert.assertTrue(range.isInside(4.5));
    }

    @Test
    public void isInsideFalseTest() {
        Range range = new Range(4, 5);
        Assert.assertFalse(range.isInside(3.5));
    }

    @Test
    public void getCrossingTest() {
        Range range1 = new Range(1, 4);
        Range range2 = new Range(2, 5);
        Range crossRange = range1.getCrossing(range2);
        Assert.assertTrue(crossRange.getFrom() == 2.0 &&
                crossRange.getTo() == 4.0);
    }

    @Test
    public void getCrossingNullTest() {
        Range range1 = new Range(1, 2);
        Range range2 = new Range(4, 5);
        Assert.assertNull(range1.getCrossing(range2));
    }

    @Test
    public void getUnionCrossTest() {
        Range range1 = new Range(1, 4);
        Range range2 = new Range(2, 5);
        Range[] ranges = range1.getUnion(range2);
        // Проверяем что в массиве один элемент - [1.0, 5.0]
        Assert.assertTrue(ranges.length == 1 &&
                ranges[0].getFrom() == 1.0 &&
                ranges[0].getTo() == 5.0);
    }

    @Test
    public void getUnionNotCrossTest() {
        Range range1 = new Range(1, 2);
        Range range2 = new Range(4, 5);
        Range[] ranges = range1.getUnion(range2);
        // Проверяем что в массиве 2 элемента - новые объекты с такими же свойствами как у range1 и range2.
        Assert.assertTrue(ranges.length == 2 &&
                ranges[0] != range1 &&
                ranges[1] != range2 &&
                ranges[0].getFrom() == range1.getFrom() && ranges[0].getTo() == range1.getTo() &&
                ranges[1].getFrom() == range2.getFrom() && ranges[1].getTo() == range2.getTo());
    }

    @Test
    public void getSubtractionNotCrossTest() {
        // когда отрезки полностью не пересекаются
        Range range1 = new Range(1, 2);
        Range range2 = new Range(4, 5);
        Range[] ranges = range1.getSubtraction(range2);
        // Проверяем что в массиве один элемент - новый объект с такими же свойствами как у range1
        Assert.assertTrue(ranges.length == 1 &&
                ranges[0] != range1 &&
                ranges[0].getFrom() == range1.getFrom() && ranges[0].getTo() == range1.getTo());
    }

    @Test
    public void getSubtractionCross1Test() {
        // отрезки пересекаются: range1.from < range2.from && range1.to <= range2.to
        Range range1 = new Range(1, 4);
        Range range2 = new Range(2, 4);
        Range[] ranges = range1.getSubtraction(range2);
        // Проверяем что в массиве один элемент - [1.0, 2.0]
        Assert.assertTrue(ranges.length == 1 &&
                ranges[0].getFrom() == 1.0 &&
                ranges[0].getTo() == 2.0);
    }

    @Test
    public void getSubtractionCross2Test() {
        // отрезки пересекаются: range1.from < range2.from && range1.to > range2.to
        Range range1 = new Range(1, 5);
        Range range2 = new Range(2, 4);
        Range[] ranges = range1.getSubtraction(range2);
        // Проверяем что в массиве 2 элемента - [1.0, 2.0], [4.0, 5.0]
        Assert.assertTrue(ranges.length == 2 &&
                ranges[0].getFrom() == 1.0 && ranges[0].getTo() == 2.0 &&
                ranges[1].getFrom() == 4.0 && ranges[1].getTo() == 5.0);
    }

    @Test
    public void getSubtractionCross3Test() {
        // отрезки пересекаются: range1.from >= range2.from && range1.to > range2.to
        Range range1 = new Range(1, 4);
        Range range2 = new Range(1, 2);
        Range[] ranges = range1.getSubtraction(range2);
        // Проверяем что в массиве один элемент - [2.0, 4.0]
        Assert.assertTrue(ranges.length == 1 &&
                ranges[0].getFrom() == 2.0 &&
                ranges[0].getTo() == 4.0);
    }

    @Test
    public void getSubtractionCross4Test() {
        // отрезки пересекаются: range1.from >= range2.from && range1.to <= range2.to
        Range range1 = new Range(1, 4);
        Range range2 = new Range(0, 6);
        Range[] ranges = range1.getSubtraction(range2);
        // Проверяем что возвращается пустой массив Ranges[]
        Assert.assertEquals(ranges.length, 0);
    }
}
