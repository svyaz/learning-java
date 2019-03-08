import com.github.svyaz.javalearning.tree.Tree;
import org.junit.Test;
import org.junit.Assert;

import java.util.Comparator;

public class TreeTest {
    @Test
    public void constructorTest() {
        Tree<String> tree = new Tree<>();
        Assert.assertEquals(tree.size(), 0);
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
        Tree<String> tree = new Tree<>(byLengthComparator);
        tree.add("1234");
        tree.add("123456");
        Assert.assertEquals(tree.size(), 2);
    }

    @Test
    public void addToLeftTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(8);
        Assert.assertEquals(tree.size(), 2);
    }

    @Test
    public void addToRightTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(12);
        Assert.assertEquals(tree.size(), 2);
    }

    @Test
    public void addNullTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(null);
        String string = "Tree (count = 2):" + System.lineSeparator() +
                "10 (left: null, right: --)" + System.lineSeparator() +
                "null (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.contains(null) && tree.size() == 2 &&
                tree.toString().equals(string));
    }

    @Test
    public void containsTrueRootTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(2);
        tree.add(12);
        Assert.assertTrue(tree.contains(10));
    }

    @Test
    public void containsTrueLeftTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(8);
        tree.add(9);
        tree.add(6);
        tree.add(7);
        tree.add(4);
        Assert.assertTrue(tree.contains(4));
    }

    @Test
    public void containsTrueRightTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(20);
        tree.add(18);
        tree.add(21);
        tree.add(22);
        Assert.assertTrue(tree.contains(22));
    }

    @Test
    public void containsFalseTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(8);
        tree.add(9);
        tree.add(6);
        tree.add(7);
        tree.add(4);
        Assert.assertFalse(tree.contains(0));
    }

    @Test
    public void containsNullTrueTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(15);
        tree.add(null);
        Assert.assertTrue(tree.contains(null));
    }

    @Test
    public void containsNullFalseTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(15);
        tree.add(5);
        Assert.assertFalse(tree.contains(null));
    }

    /* Удаление корня когда нет потомков */
    @Test
    public void removeRootWithoutSonsTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        Assert.assertTrue(tree.remove(10) && tree.size() == 0);
    }

    /* Удаление корня когда только левый потомок */
    @Test
    public void removeRootWitOnlyLeftSonTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(6);
        tree.add(4);
        String string = "Tree (count = 2):" + System.lineSeparator() +
                "6 (left: 4, right: --)" + System.lineSeparator() +
                "4 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(10) && tree.size() == 2 && !tree.contains(10) &&
                tree.toString().equals(string));
    }

    /* Удаление корня когда только правый потомок */
    @Test
    public void removeRootWitOnlyRightSonTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(16);
        tree.add(20);
        String string = "Tree (count = 2):" + System.lineSeparator() +
                "16 (left: --, right: 20)" + System.lineSeparator() +
                "20 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(10) && tree.size() == 2 && !tree.contains(10) &&
                tree.toString().equals(string));
    }

    /* Удаление корня когда оба потомка */
    @Test
    public void removeRootWitBothSons() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        String string = "Tree (count = 4):" + System.lineSeparator() +
                "14 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: --, right: --)" + System.lineSeparator() +
                "16 (left: --, right: 20)" + System.lineSeparator() +
                "20 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(10) && tree.size() == 4 && !tree.contains(10) &&
                tree.toString().equals(string));
    }

    /* Удаление левого листа */
    @Test
    public void removeLeftLeafTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        String string = "Tree (count = 4):" + System.lineSeparator() +
                "10 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: --, right: --)" + System.lineSeparator() +
                "16 (left: --, right: 20)" + System.lineSeparator() +
                "20 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(14) && tree.size() == 4 && !tree.contains(14) &&
                tree.toString().equals(string));
    }

    /* Удаление правого листа */
    @Test
    public void removeRightLeafTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        String string = "Tree (count = 4):" + System.lineSeparator() +
                "10 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: --, right: --)" + System.lineSeparator() +
                "16 (left: 14, right: --)" + System.lineSeparator() +
                "14 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(20) && tree.size() == 4 && !tree.contains(20) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с одним левым потомком */
    @Test
    public void removeNodeWithOnlyOneLeftSonTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(12);
        String string = "Tree (count = 5):" + System.lineSeparator() +
                "10 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: --, right: --)" + System.lineSeparator() +
                "16 (left: 12, right: 20)" + System.lineSeparator() +
                "12 (left: --, right: --)" + System.lineSeparator() +
                "20 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(14) && tree.size() == 5 && !tree.contains(14) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с одним правым потомком */
    @Test
    public void removeNodeWithOnlyOneRightSonTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(15);
        String string = "Tree (count = 5):" + System.lineSeparator() +
                "10 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: --, right: --)" + System.lineSeparator() +
                "16 (left: 15, right: 20)" + System.lineSeparator() +
                "15 (left: --, right: --)" + System.lineSeparator() +
                "20 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(14) && tree.size() == 5 && !tree.contains(14) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с двумя потомками. В правой ветви только один элемент. */
    @Test
    public void removeNodeWithTwoSons1RightNodeTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(15);
        String string = "Tree (count = 5):" + System.lineSeparator() +
                "10 (left: 6, right: 20)" + System.lineSeparator() +
                "6 (left: --, right: --)" + System.lineSeparator() +
                "20 (left: 14, right: --)" + System.lineSeparator() +
                "14 (left: --, right: 15)" + System.lineSeparator() +
                "15 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(16) && tree.size() == 5 && !tree.contains(16) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с двумя потомками. В правой ветви есть левый элемент без потомков. */
    @Test
    public void removeNodeWithTwoSonsLeftWithoutSonsTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(18);
        String string = "Tree (count = 5):" + System.lineSeparator() +
                "10 (left: 6, right: 18)" + System.lineSeparator() +
                "6 (left: --, right: --)" + System.lineSeparator() +
                "18 (left: 14, right: 20)" + System.lineSeparator() +
                "14 (left: --, right: --)" + System.lineSeparator() +
                "20 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(16) && tree.size() == 5 && !tree.contains(16) &&
                tree.toString().equals(string));
    }

    /* Удаление элеменита с двумя потомками. В правой ветви есть левый элемент с правым потомков. */
    @Test
    public void removeNodeWithTwoSonsLeftWithRightSonTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(6);
        tree.add(16);
        tree.add(14);
        tree.add(20);
        tree.add(18);
        tree.add(19);
        String string = "Tree (count = 6):" + System.lineSeparator() +
                "10 (left: 6, right: 18)" + System.lineSeparator() +
                "6 (left: --, right: --)" + System.lineSeparator() +
                "18 (left: 14, right: 20)" + System.lineSeparator() +
                "14 (left: --, right: --)" + System.lineSeparator() +
                "20 (left: 19, right: --)" + System.lineSeparator() +
                "19 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(16) && tree.size() == 6 && !tree.contains(16) &&
                tree.toString().equals(string));
    }

    /* Элемент не найден в пустом дереве. */
    @Test
    public void removeElementNotFountInEmptyTreeTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
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
        Tree<Integer> tree = new Tree<>();
        Assert.assertFalse(tree.remove(50));
    }

    /* Удаление null */
    @Test
    public void removeNullTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(null);
        tree.add(6);
        tree.add(16);
        tree.add(5);
        tree.add(7);
        String string = "Tree (count = 5):" + System.lineSeparator() +
                "10 (left: 6, right: 16)" + System.lineSeparator() +
                "6 (left: 5, right: 7)" + System.lineSeparator() +
                "16 (left: --, right: --)" + System.lineSeparator() +
                "5 (left: --, right: --)" + System.lineSeparator() +
                "7 (left: --, right: --)" + System.lineSeparator();
        Assert.assertTrue(tree.remove(null) && tree.size() == 5 && !tree.contains(null) &&
                tree.toString().equals(string));
    }

    @Test
    public void toStringNotEmptyTest() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(8);
        tree.add(18);
        String string = "Tree (count = 3):" + System.lineSeparator() +
                "10 (left: 8, right: 18)" + System.lineSeparator() +
                "8 (left: --, right: --)" + System.lineSeparator() +
                "18 (left: --, right: --)" + System.lineSeparator();
        Assert.assertEquals(tree.toString(), string);
    }

    @Test
    public void toStringEmptyTest() {
        Tree<Integer> tree = new Tree<>();
        String string = "Tree (count = 0):" + System.lineSeparator() + "empty";
        Assert.assertEquals(tree.toString(), string);
    }

    @Test
    public void equalsSameObjectTest() {
        Tree<String> tree = new Tree<>();
        Assert.assertEquals(tree, tree);
    }

    @Test
    public void equalsNullTest() {
        Tree<String> tree = new Tree<>();
        Assert.assertNotEquals(tree, null);
    }

    @Test
    public void equalsDifferentTypesObjectsTest() {
        Tree<String> tree = new Tree<>();
        tree.add("Hi there");
        StringBuilder object = new StringBuilder("Hi there");
        Assert.assertNotEquals(tree, object);
    }

    @Test
    public void equalsDifferentDataTypesTest() {
        Tree<Integer> intTree = new Tree<>();
        intTree.add(10);
        Tree<Double> doubleTree = new Tree<>();
        doubleTree.add(10.0);
        Assert.assertNotEquals(intTree, doubleTree);
    }

    @Test
    public void equalsDifferentSizesTest() {
        Tree<String> tree1 = new Tree<>();
        tree1.add("Hi there");
        tree1.add("Hello world!");
        Tree<String> tree2 = new Tree<>();
        tree2.add("Hi there");
        Assert.assertNotEquals(tree1, tree2);
    }

    @Test
    public void equalsTrueTest() {
        Tree<Integer> tree1 = new Tree<>();
        tree1.add(10);
        tree1.add(5);
        tree1.add(15);
        Tree<Integer> tree2 = new Tree<>();
        tree2.add(10);
        tree2.add(5);
        tree2.add(15);
        Assert.assertEquals(tree1, tree2);
    }

    @Test
    public void equalsFalseTest() {
        Tree<Integer> tree1 = new Tree<>();
        tree1.add(10);
        tree1.add(5);
        tree1.add(15);
        Tree<Integer> tree2 = new Tree<>();
        tree2.add(10);
        tree2.add(5);
        tree2.add(14);
        Assert.assertNotEquals(tree1, tree2);
    }

    @Test
    public void hashCode1Test() {
        Tree<String> tree = new Tree<>();
        tree.add("1 item");
        tree.add("2 item");
        tree.add("3 item");
        Assert.assertEquals(tree.hashCode(), -1888439672);
    }

    @Test
    @SuppressWarnings("all")
    public void hashCode2Test() {
        Tree<String> tree1 = new Tree<>();
        tree1.add(new String("Hi there"));
        Tree<String> tree2 = new Tree<>();
        tree2.add(new String("Hi there"));
        Assert.assertEquals(tree1.hashCode(), tree2.hashCode());
    }

    @Test
    public void hashCode3Test() {
        Tree<String> tree1 = new Tree<>();
        tree1.add("Hi");
        tree1.add("there");
        Tree<String> tree2 = new Tree<>();
        tree2.add("Hi");
        tree2.add("buddy");
        Assert.assertNotEquals(tree1.hashCode(), tree2.hashCode());
    }
}
