import com.github.svyaz.javalearning.myarraylist.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {
    @Test
    public void constructorTest() {

    }

    @Test
    public void sizeEmptyTest() {
        MyArrayList<String> list = new MyArrayList<>();
        Assert.assertEquals(list.size(), 0);
    }

    // TODO Implement this test!
    /*@Test
    public void sizeNotEmptyTest() {
        MyArrayList<Object> list = new MyArrayList<>();
        Assert.assertEquals(list.size(), 10);
    }*/

    @Test
    public void addTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hi there");
        Assert.assertTrue(list.size() == 1 &&
                list.get(0).getClass() == String.class &&
                list.get(0).equals("Hi there"));
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
        //list.add(5);
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
        MyArrayList<Integer> list = new MyArrayList<>();
        //list.add(5);
        list.set(1, 2);
    }
}
