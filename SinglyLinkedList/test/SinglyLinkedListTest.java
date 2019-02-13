import com.github.svyaz.javalearning.singlylinkedlist.ListItem;
import com.github.svyaz.javalearning.singlylinkedlist.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {
    @Test
    public void constructor1Items1Test() {
        ListItem<String> startItem = new ListItem<>("Hi there", null);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(startItem);
        Assert.assertTrue(list.size() == 1 && list.getHeadData().equals("Hi there"));
    }

    @Test
    public void constructor1Items3Test() {
        ListItem<String> thirdItem = new ListItem<>("3 item", null);
        ListItem<String> secondItem = new ListItem<>("2 item", thirdItem);
        ListItem<String> firstItem = new ListItem<>("1 item", secondItem);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstItem);
        Assert.assertEquals(list.size(), 3);
    }

    @Test
    public void constructor2Test() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("Hi there");
        Assert.assertTrue(list.size() == 1 && list.getHeadData().equals("Hi there"));
    }

    @Test
    public void getDataIndexTest() {
        ListItem<String> thirdItem = new ListItem<>("3 item", null);
        ListItem<String> secondItem = new ListItem<>("2 item", thirdItem);
        ListItem<String> firstItem = new ListItem<>("1 item", secondItem);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstItem);
        Assert.assertTrue(list.size() == 3 &&
                list.getData(0).equals("1 item") &&
                list.getData(1).equals("2 item") &&
                list.getData(2).equals("3 item"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getDataIndexException1Test() {
        ListItem<String> thirdItem = new ListItem<>("3 item", null);
        ListItem<String> secondItem = new ListItem<>("2 item", thirdItem);
        ListItem<String> firstItem = new ListItem<>("1 item", secondItem);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstItem);
        list.getData(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getDataIndexException2Test() {
        ListItem<String> thirdItem = new ListItem<>("3 item", null);
        ListItem<String> secondItem = new ListItem<>("2 item", thirdItem);
        ListItem<String> firstItem = new ListItem<>("1 item", secondItem);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstItem);
        list.getData(3);
    }

    @Test
    public void setDataTest() {
        ListItem<String> thirdItem = new ListItem<>("3 item", null);
        ListItem<String> secondItem = new ListItem<>("2 item", thirdItem);
        ListItem<String> firstItem = new ListItem<>("1 item", secondItem);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstItem);
        Assert.assertEquals(list.setData(1, "Second item!"), "2 item");
    }

    @Test
    public void setDataToHeadByIndexTest() {
        ListItem<String> thirdItem = new ListItem<>("3 item", null);
        ListItem<String> secondItem = new ListItem<>("2 item", thirdItem);
        ListItem<String> firstItem = new ListItem<>("1 item", secondItem);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstItem);
        Assert.assertEquals(list.setData(0, "Head item!"), "1 item");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setDataIndexException1Test() {
        ListItem<String> thirdItem = new ListItem<>("3 item", null);
        ListItem<String> secondItem = new ListItem<>("2 item", thirdItem);
        ListItem<String> firstItem = new ListItem<>("1 item", secondItem);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstItem);
        list.setData(-1, "Hi there");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setDataIndexException2Test() {
        ListItem<String> thirdItem = new ListItem<>("3 item", null);
        ListItem<String> secondItem = new ListItem<>("2 item", thirdItem);
        ListItem<String> firstItem = new ListItem<>("1 item", secondItem);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstItem);
        list.setData(3, "Hi there");
    }
}
