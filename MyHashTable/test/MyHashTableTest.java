import com.github.svyaz.javalearning.myhashtable.MyHashTable;
import org.junit.Assert;
import org.junit.Test;

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
}
