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
    public void containsTrueRootTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(2);
        tree.add(12);
        Assert.assertTrue(tree.contains(10));
    }

    @Test
    public void containsTrueLeftTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(8);
        tree.add(9);
        tree.add(6);
        tree.add(7);
        tree.add(4);
        Assert.assertTrue(tree.contains(4));
    }

    @Test
    public void containsTrueRightTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(20);
        tree.add(18);
        tree.add(21);
        tree.add(22);
        Assert.assertTrue(tree.contains(22));
    }

    @Test
    public void containsFalseTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(8);
        tree.add(9);
        tree.add(6);
        tree.add(7);
        tree.add(4);
        Assert.assertFalse(tree.contains(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void containsExceptionTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.contains(null);
    }

    /* Удаление корня когда нет потомков */
    @Test
    public void removeRootWithoutSonsTest() {
        Tree<Integer> tree = new Tree<>(10);
        Assert.assertTrue(tree.remove(10) && tree.size() == 0);
    }

    /* Удаление корня когда только левый потомок */
    @Test
    public void removeRootWitOnlyLeftSonTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(4);
        String string = "Tree (count = 2):" + System.lineSeparator() +
                "6 (left: 4, right: null)" + System.lineSeparator() +
                "4 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(10) && tree.size() == 2 && !tree.contains(10) &&
                tree.toString().equals(string));
    }

    /* Удаление корня когда только правый потомок */
    @Test
    public void removeRootWitOnlyRightSonTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(16);
        tree.add(20);
        String string = "Tree (count = 2):" + System.lineSeparator() +
                "16 (left: null, right: 20)" + System.lineSeparator() +
                "20 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(10) && tree.size() == 2 && !tree.contains(10) &&
                tree.toString().equals(string));
    }

    /* Удаление корня когда оба потомка */
    @Test
    public void removeRootWitBothSons() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        String string = "Tree (count = 4):" + System.lineSeparator() +
                "14 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: null, right: null)" + System.lineSeparator() +
                "16 (left: null, right: 20)" + System.lineSeparator() +
                "20 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(10) && tree.size() == 4 && !tree.contains(10) &&
                tree.toString().equals(string));
    }

    /* Удаление левого листа */
    @Test
    public void removeLeftLeafTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        String string = "Tree (count = 4):" + System.lineSeparator() +
                "10 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: null, right: null)" + System.lineSeparator() +
                "16 (left: null, right: 20)" + System.lineSeparator() +
                "20 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(14) && tree.size() == 4 && !tree.contains(14) &&
                tree.toString().equals(string));
    }

    /* Удаление правого листа */
    @Test
    public void removeRightLeafTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        String string = "Tree (count = 4):" + System.lineSeparator() +
                "10 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: null, right: null)" + System.lineSeparator() +
                "16 (left: 14, right: null)" + System.lineSeparator() +
                "14 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(20) && tree.size() == 4 && !tree.contains(20) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с одним левым потомком */
    @Test
    public void removeNodeWithOnlyOneLeftSonTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(12);
        String string = "Tree (count = 5):" + System.lineSeparator() +
                "10 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: null, right: null)" + System.lineSeparator() +
                "16 (left: 12, right: 20)" + System.lineSeparator() +
                "12 (left: null, right: null)" + System.lineSeparator() +
                "20 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(14) && tree.size() == 5 && !tree.contains(14) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с одним правым потомком */
    @Test
    public void removeNodeWithOnlyOneRightSonTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(15);
        String string = "Tree (count = 5):" + System.lineSeparator() +
                "10 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: null, right: null)" + System.lineSeparator() +
                "16 (left: 15, right: 20)" + System.lineSeparator() +
                "15 (left: null, right: null)" + System.lineSeparator() +
                "20 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(14) && tree.size() == 5 && !tree.contains(14) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с двумя потомками. В правой ветви только один элемент. */
    @Test
    public void removeNodeWithTwoSons1RightNodeTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(15);
        String string = "Tree (count = 5):" + System.lineSeparator() +
                "10 (left: 6, right: 20)" + System.lineSeparator() +
                "6 (left: null, right: null)" + System.lineSeparator() +
                "20 (left: 14, right: null)" + System.lineSeparator() +
                "14 (left: null, right: 15)" + System.lineSeparator() +
                "15 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(16) && tree.size() == 5 && !tree.contains(16) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с двумя потомками. В правой ветви есть левый элемент без потомков. */
    @Test
    public void removeNodeWithTwoSonsLeftWithoutSonsTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(18);
        String string = "Tree (count = 5):" + System.lineSeparator() +
                "10 (left: 6, right: 18)" + System.lineSeparator() +
                "6 (left: null, right: null)" + System.lineSeparator() +
                "18 (left: 14, right: 20)" + System.lineSeparator() +
                "14 (left: null, right: null)" + System.lineSeparator() +
                "20 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(16) && tree.size() == 5 && !tree.contains(16) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с двумя потомками. В правой ветви есть левый элемент с правым потомков. */
    @Test
    public void removeNodeWithTwoSonsLeftWithRightSonTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(18);
        tree.add(19);
        String string = "Tree (count = 6):" + System.lineSeparator() +
                "10 (left: 6, right: 18)" + System.lineSeparator() +
                "6 (left: null, right: null)" + System.lineSeparator() +
                "18 (left: 14, right: 20)" + System.lineSeparator() +
                "14 (left: null, right: null)" + System.lineSeparator() +
                "20 (left: 19, right: null)" + System.lineSeparator() +
                "19 (left: null, right: null)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(16) && tree.size() == 6 && !tree.contains(16) &&
                tree.toString().equals(string));
    }

    /* Элемент не найден в пустом дереве. */
    @Test
    public void removeElementNotFountInEmptyTreeTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(18);
        tree.add(19);
        Assert.assertFalse(tree.remove(50));
    }

    /* Элемент не найден в пустом дереве. */
    @Test
    public void removeElementNotFountTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.remove(10);
        Assert.assertFalse(tree.remove(50));
    }

    /* IllegalArgumentException test */
    @Test(expected = IllegalArgumentException.class)
    public void removeIllegalArgumentExceptionTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.remove(null);
    }

    @Test
    public void toStringTest() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(8);
        tree.add(18);
        String string = "Tree (count = 3):" + System.lineSeparator() +
                "10 (left: 8, right: 18)" + System.lineSeparator() +
                "8 (left: null, right: null)" + System.lineSeparator() +
                "18 (left: null, right: null)" + System.lineSeparator();
        Assert.assertEquals(tree.toString(), string);
    }

    //TODO empty tree toString test
}
