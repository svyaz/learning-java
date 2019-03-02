import com.github.svyaz.javalearning.tree.Tree;
import org.junit.Test;
import org.junit.Assert;

public class TreeTest {
    @Test
    public void constructorTest() {
        Tree<String> tree = new Tree<>("Hello Tree!");
        Assert.assertEquals(tree.size(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest() {
        new Tree<String>(null);
    }

    @Test
    public void addToLeftTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(8);
        Assert.assertEquals(tree.size(), 2);
    }

    @Test
    public void addToRightTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(12);
        Assert.assertEquals(tree.size(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addExceptionTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(null);
    }

    @Test
    public void toStringTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(8);
        tree.add(18);
        String sb = "Tree:" + System.lineSeparator() +
                "10 (left: 8, right: 18)" + System.lineSeparator() +
                "8 (left: null, right: null)" + System.lineSeparator() +
                "18 (left: null, right: null)" + System.lineSeparator();
        Assert.assertEquals(tree.toString(), sb);
    }
}
