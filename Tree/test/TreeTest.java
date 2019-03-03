import com.github.svyaz.javalearning.tree.Tree;
import org.junit.Test;
import org.junit.Assert;

import java.util.Comparator;

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
    @SuppressWarnings("all")
    public void constructorWithComparatorTest() {
        Comparator<String> byLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
        Tree<String> tree = new Tree<>("12345", byLengthComparator);
        tree.add("1234");
        tree.add("123456");
        Assert.assertEquals(tree.size(), 3);
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
    public void searchTrueRootTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(2);
        tree.add(12);
        Assert.assertTrue(tree.search(10));
    }

    @Test
    public void searchTrueLeftTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(8);
        tree.add(9);
        tree.add(6);
        tree.add(7);
        tree.add(4);
        Assert.assertTrue(tree.search(4));
    }

    @Test
    public void searchTrueRightTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(20);
        tree.add(18);
        tree.add(21);
        tree.add(22);
        Assert.assertTrue(tree.search(22));
    }

    @Test
    public void searchFalseTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(8);
        tree.add(9);
        tree.add(6);
        tree.add(7);
        tree.add(4);
        Assert.assertFalse(tree.search(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchExceptionTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.search(null);
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
