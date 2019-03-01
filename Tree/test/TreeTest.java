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
}
