import com.github.svyaz.javalearning.myarraylist.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {

    // TODO constructors tests!!!

    @Test
    public void sizeEmptyTest() {
        MyArrayList<String> list = new MyArrayList<>();
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void sizeNotEmptyTest() {
        MyArrayList<Integer> list = new MyArrayList<>(new Integer[]{5, 2});
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    public void isEmptyTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void isNotEmptyTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void addTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hi there");
        Assert.assertTrue(list.size() == 1 &&
                list.get(0).getClass() == String.class &&
                list.get(0).equals("Hi there"));
    }

    @Test
    public void addNullTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add(null);
        Assert.assertTrue(list.size() == 1 &&
                list.get(0) == null);
    }

    @Test
    public void addWithIndex0Test() {
        MyArrayList<Integer> list = new MyArrayList<>(3);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(0, 10);
        Assert.assertTrue(list.size() == 4 &&
                list.get(0) == 10 && list.get(1) == 0 && list.get(2) == 1 && list.get(3) == 2);
    }

    @Test
    public void addWithIndexLastTest() {
        MyArrayList<Integer> list = new MyArrayList<>(3);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(2, 10);
        Assert.assertTrue(list.size() == 4 &&
                list.get(0) == 0 && list.get(1) == 1 && list.get(2) == 10 && list.get(3) == 2);
    }

    @Test
    public void addWithIndexMiddleTest() {
        MyArrayList<Integer> list = new MyArrayList<>(3);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(1, 10);
        Assert.assertTrue(list.size() == 4 &&
                list.get(0) == 0 && list.get(1) == 10 && list.get(2) == 1 && list.get(3) == 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addException1Test() {
        MyArrayList<Integer> list = new MyArrayList<>(3);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(-1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addException2Test() {
        MyArrayList<Integer> list = new MyArrayList<>(3);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3, 100);
    }

    @Test
    public void remove0Test() {
        MyArrayList<Integer> list = new MyArrayList<>(new Integer[]{10, 11, 12});
        Assert.assertTrue(list.remove(0) == 10 &&
                list.size() == 2 && list.get(0) == 11 && list.get(1) == 12);
    }

    @Test
    public void removeLastTest() {
        MyArrayList<Integer> list = new MyArrayList<>(new Integer[]{10, 11, 12});
        Assert.assertTrue(list.remove(2) == 12 &&
                list.size() == 2 && list.get(0) == 10 && list.get(1) == 11);
    }

    @Test
    public void removeMiddleTest() {
        MyArrayList<Integer> list = new MyArrayList<>(new Integer[]{10, 11, 12});
        Assert.assertTrue(list.remove(1) == 11 &&
                list.size() == 2 && list.get(0) == 10 && list.get(1) == 12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeException1Test() {
        MyArrayList<Integer> list = new MyArrayList<>(new Integer[]{10, 11, 12});
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeException2Test() {
        MyArrayList<Integer> list = new MyArrayList<>(new Integer[]{10, 11, 12});
        list.remove(3);
    }

    @Test
    public void indexOfTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        Assert.assertEquals(list.indexOf("like"), 1);
    }

    @Test
    public void indexOfNotFoundTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        Assert.assertEquals(list.indexOf("C++"), -1);
    }

    @Test
    public void indexOfNullFoundTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "don't", "like", null});
        Assert.assertEquals(list.indexOf(null), 3);
    }

    @Test
    public void indexOfNullNotFoundTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        Assert.assertEquals(list.indexOf(null), -1);
    }

    @Test
    public void lastIndexOfTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "like", "Java"});
        Assert.assertEquals(list.lastIndexOf("like"), 2);
    }

    @Test
    public void lastIndexOfNotFoundTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        Assert.assertEquals(list.lastIndexOf("C++"), -1);
    }

    @Test
    public void lastIndexOfNullFoundTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "don't", "like", null, "Oh", null, "no"});
        Assert.assertEquals(list.lastIndexOf(null), 5);
    }

    @Test
    public void lastIndexOfNullNotFoundTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        Assert.assertEquals(list.lastIndexOf(null), -1);
    }

    @Test
    public void containsTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        Assert.assertTrue(list.contains("like"));
    }

    @Test
    public void containsFalseTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        Assert.assertFalse(list.contains("C++"));
    }

    @Test
    public void containsNullTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "don't", "like", null});
        Assert.assertTrue(list.contains(null));
    }

    @Test
    public void containsNullFalseTest() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        Assert.assertFalse(list.contains(null));
    }

    @Test
    public void toArrayTest() {
        MyArrayList<Integer> list = new MyArrayList<>(new Integer[]{10, 11, 12});
        Object[] result = list.toArray();
        Assert.assertTrue(result.length == 3 &&
                (int) result[0] == 10 && (int) result[1] == 11 && (int) result[2] == 12);
    }

    @Test
    public void toArrayEmptyTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Assert.assertEquals(list.toArray().length, 0);
    }

    @Test
    public void toArrayT1Test() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        String[] strings = {"str_0", "str_1", "str_2", "str_3"};
        String[] newStrings = list.toArray(strings);
        Assert.assertTrue(newStrings == strings &&
                newStrings[0].equals("I") &&
                newStrings[1].equals("like") &&
                newStrings[2].equals("Java") &&
                newStrings[3] == null);
    }

    @Test
    public void toArrayT2Test() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        String[] strings = {"str_0", "str_1", "str_2"};
        String[] newStrings = list.toArray(strings);
        Assert.assertTrue(newStrings == strings &&
                newStrings[0].equals("I") &&
                newStrings[1].equals("like") &&
                newStrings[2].equals("Java"));
    }

    @Test
    public void toArrayT3Test() {
        MyArrayList<String> list = new MyArrayList<>(new String[]{"I", "like", "Java"});
        String[] strings = {"str_0", "str_1"};
        String[] newStrings = list.toArray(strings);
        Assert.assertTrue(newStrings != strings &&
                newStrings[0].equals("I") &&
                newStrings[1].equals("like") &&
                newStrings[2].equals("Java"));
    }

    @Test
    public void addWithIncreaseCapacityTest() {
        MyArrayList<Integer> list = new MyArrayList<>(1);
        list.add(5);
        list.add(2);
        Assert.assertTrue(list.size() == 2 &&
                list.get(0) == 5 &&
                list.get(1) == 2);
    }

    @Test
    public void clearTest() {
        MyArrayList<Integer> list = new MyArrayList<>(new Integer[]{0, 1, 2});
        list.clear();
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void getTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        Assert.assertEquals(list.get(0).intValue(), 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceptionTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.get(1);
    }

    @Test
    public void setTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        int currentElement = list.set(0, 2);
        Assert.assertTrue(list.get(0) == 2 && currentElement == 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setExceptionTest() {
        MyArrayList<Integer> list = new MyArrayList<>(new Integer[]{});
        list.set(1, 2);
    }

    /**
     * Nothing asserts in trimToSizeTest below.
     * Test only fails if any exception is thrown.
     */
    @Test
    public void trimToSizeTest() {
        MyArrayList<Integer> list = new MyArrayList<>(4);
        list.add(5);
        list.trimToSize();
    }
}
