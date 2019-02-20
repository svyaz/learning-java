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
}
