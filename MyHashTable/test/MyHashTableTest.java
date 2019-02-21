import com.github.svyaz.javalearning.myhashtable.MyHashTable;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class MyHashTableTest {
    @Test
    public void constructor1Test() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        Assert.assertNotNull(hashTable);
    }

    @Test
    public void constructor2Test() {
        MyHashTable<String> hashTable = new MyHashTable<>(15);
        Assert.assertNotNull(hashTable);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor2ExceptionTest() {
        new MyHashTable<String>(-10);
    }

    @Test
    public void toArrayTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi");
        hashTable.add("there!");
        hashTable.add(null);
        hashTable.add("Hi there!");
        Object[] objects = hashTable.toArray();
        Assert.assertTrue(objects.length == 4 &&
                Objects.equals(objects[0], null) &&
                objects[1].equals("Hi there!") &&
                objects[2].equals("Hi") &&
                objects[3].equals("there!"));
    }

    @Test
    public void toArrayEmptyTest() {
        Assert.assertEquals(new MyHashTable<>().toArray().length, 0);
    }

    @Test
    public void addAndSizeTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi there!");
        hashTable.add("I");
        hashTable.add("like");
        hashTable.add("Java");
        Assert.assertEquals(hashTable.size(), 4);
    }

    @Test
    public void addNullTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add(null);
        hashTable.add(null);
        Assert.assertEquals(hashTable.size(), 2);
    }

    @Test
    public void removeEmptyTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        Assert.assertFalse(hashTable.remove("Hi there!"));
    }

    @Test
    public void removeFalseTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi");
        hashTable.add("there!");
        Assert.assertFalse(hashTable.remove("Hi there!"));
    }

    @Test
    public void removeTrueTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi");
        hashTable.add("there!");
        hashTable.add("Hi there!");
        System.out.println(hashTable.toString());
        Assert.assertTrue(hashTable.remove("Hi there!"));
    }

    @Test
    public void removeOneArrayItemFalseTest() {
        MyHashTable<String> hashTable = new MyHashTable<>(1);
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        Assert.assertFalse(hashTable.remove("4"));
    }

    @Test
    public void removeOneArrayItemTrueTest() {
        MyHashTable<String> hashTable = new MyHashTable<>(1);
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        Assert.assertTrue(hashTable.remove("2") && hashTable.size() == 2);
    }

    @Test
    public void removeNullFalseTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        Assert.assertFalse(hashTable.remove(null));
    }

    @Test
    public void removeNullTrueTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi");
        hashTable.add(null);
        hashTable.add("null");
        Assert.assertTrue(hashTable.remove(null) && hashTable.size() == 2);
    }

    @Test
    @SuppressWarnings("all")
    public void sizeOfEmptyTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        Assert.assertEquals(hashTable.size(), 0);
    }

    @Test
    @SuppressWarnings("all")
    public void isEmptyTrueTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        Assert.assertTrue(hashTable.isEmpty());
    }

    @Test
    public void isEmptyFalseTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi there");
        Assert.assertFalse(hashTable.isEmpty());
    }

    @Test
    public void clearTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi there");
        hashTable.clear();
        Assert.assertEquals(hashTable.size(), 0);
    }

    @Test
    @SuppressWarnings("all")
    public void containsEmptyTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        Assert.assertFalse(hashTable.contains("Hi there"));
    }

    @Test
    public void containsNullArrayItemTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        Assert.assertFalse(hashTable.contains("2"));
    }

    @Test
    public void containsOneArrayItemFalseTest() {
        MyHashTable<String> hashTable = new MyHashTable<>(1);
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        Assert.assertFalse(hashTable.contains("4"));
    }

    @Test
    public void containsOneArrayItemTrueTest() {
        MyHashTable<String> hashTable = new MyHashTable<>(1);
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        Assert.assertTrue(hashTable.contains("2"));
    }

    @Test
    public void containsNullFalseTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi there");
        Assert.assertFalse(hashTable.contains(null));
    }

    @Test
    public void containsNullTrueTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi there");
        hashTable.add(null);
        Assert.assertTrue(hashTable.contains(null));
    }

    @Test
    public void containsTrueTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("I");
        hashTable.add("like");
        hashTable.add("Java");
        Assert.assertTrue(hashTable.contains("Java"));
    }

    @Test
    public void containsFalseTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("I");
        hashTable.add("like");
        hashTable.add("Java");
        Assert.assertFalse(hashTable.contains("C++"));
    }


    @Test
    public void toStringTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi");
        hashTable.add("there!");
        hashTable.add("Hi there!");
        Assert.assertEquals(hashTable.toString(), "[[Hi there!], [Hi, there!]]");
    }

    @Test
    public void toStringNullTest() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("Hi");
        hashTable.add("there!");
        hashTable.add(null);
        Assert.assertEquals(hashTable.toString(), "[[null], [Hi, there!]]");
    }

    @Test
    public void toStringEmptyTest() {
        Assert.assertEquals(new MyHashTable<>(15).toString(), "[]");
    }
}
