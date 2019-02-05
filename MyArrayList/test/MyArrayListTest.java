import com.github.svyaz.javalearning.myarraylist.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {
    @Test
    public void constructorTest() {

    }

    @Test
    public void sizeEmptyTest() {
        MyArrayList<Object> list = new MyArrayList<>();
        Assert.assertEquals(list.size(), 0);
    }
}
