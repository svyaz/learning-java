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

    // TODO check all 3 elements
    @Test
    public void constructor1Items3Test() {
        ListItem<String> thirdItem = new ListItem<>("3 item", null);
        ListItem<String> secondItem = new ListItem<>("2 item", thirdItem);
        ListItem<String> firstItem = new ListItem<>("1 item", secondItem);
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstItem);
        Assert.assertTrue(list.size() == 3);
    }

    @Test
    public void constructor2Test() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("Hi there");
        Assert.assertTrue(list.size() == 1 && list.getHeadData().equals("Hi there"));
    }



}
