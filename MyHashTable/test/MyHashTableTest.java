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



    // TODO size() tests
    // TODO isEmpty() tests
}
