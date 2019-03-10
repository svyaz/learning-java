import com.github.svyaz.javalearning.graph.Graph;
import com.github.svyaz.javalearning.graph.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph<String> graph;

    @Before
    @SuppressWarnings("unchecked")
    public void createGraph() {
        Vertex<String>[] names = (Vertex<String>[]) new Vertex[3];
        names[0] = new Vertex<>("Tom");
        names[1] = new Vertex<>("Bob");
        names[2] = new Vertex<>("Sam");
        int[][] adjMatrix = new int[names.length][names.length];
        adjMatrix[0] = new int[]{0, 1, 1};
        adjMatrix[1] = new int[]{1, 0, 0};
        adjMatrix[2] = new int[]{1, 0, 0};
        this.graph = new Graph<>(names, adjMatrix);
    }

    @Test
    public void constructorTest() {
        Assert.assertTrue(graph.size() == 3 &&
                graph.get(0).getData().equals("Tom") &&
                graph.get(1).getData().equals("Bob") &&
                graph.get(2).getData().equals("Sam"));
    }

    @Test
    public void equalsSameObjectTest() {
        Assert.assertEquals(graph, graph);
    }

    @Test
    public void equalsNullTest() {
        Assert.assertNotEquals(graph, null);
    }

    @Test
    public void equalsDifferentTypesObjectsTest() {
        Assert.assertNotEquals(graph, "Hi there");
    }

    @Test
    @SuppressWarnings("unchecked")
    public void equalsDifferentDataTypesTest() {
        Vertex<Integer>[] integers = (Vertex<Integer>[]) new Vertex[3];
        integers[0] = new Vertex<>(1234);
        integers[1] = new Vertex<>(5678);
        integers[2] = new Vertex<>(9010);
        int[][] adjMatrix = new int[integers.length][integers.length];
        adjMatrix[0] = new int[]{0, 1, 1};
        adjMatrix[1] = new int[]{1, 0, 0};
        adjMatrix[2] = new int[]{1, 0, 0};
        Graph<Integer> newGraph = new Graph<>(integers, adjMatrix);
        Assert.assertNotEquals(graph, newGraph);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void equalsTrueTest() {
        Vertex<String>[] names = (Vertex<String>[]) new Vertex[3];
        names[0] = new Vertex<>("Tom");
        names[1] = new Vertex<>("Bob");
        names[2] = new Vertex<>("Sam");
        int[][] adjMatrix = new int[names.length][names.length];
        adjMatrix[0] = new int[]{0, 1, 1};
        adjMatrix[1] = new int[]{1, 0, 0};
        adjMatrix[2] = new int[]{1, 0, 0};
        Graph<String> newGraph = new Graph<>(names, adjMatrix);
        Assert.assertEquals(graph, newGraph);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void equalsFalseTest() {
        Vertex<String>[] names = (Vertex<String>[]) new Vertex[3];
        names[0] = new Vertex<>("Tom");
        names[1] = new Vertex<>("Bob");
        names[2] = new Vertex<>("Eva");
        int[][] adjMatrix = new int[names.length][names.length];
        adjMatrix[0] = new int[]{0, 1, 1};
        adjMatrix[1] = new int[]{1, 0, 0};
        adjMatrix[2] = new int[]{1, 0, 0};
        Graph<String> newGraph = new Graph<>(names, adjMatrix);
        Assert.assertNotEquals(graph, newGraph);
    }

    @Test
    public void hashCode1Test() {
        Assert.assertEquals(graph.hashCode(), 1638911791);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void hashCode2Test() {
        Vertex<String>[] names = (Vertex<String>[]) new Vertex[3];
        names[0] = new Vertex<>("Tom");
        names[1] = new Vertex<>("Bob");
        names[2] = new Vertex<>("Sam");
        int[][] adjMatrix = new int[names.length][names.length];
        adjMatrix[0] = new int[]{0, 1, 1};
        adjMatrix[1] = new int[]{1, 0, 0};
        adjMatrix[2] = new int[]{1, 0, 0};
        Graph<String> newGraph = new Graph<>(names, adjMatrix);
        Assert.assertEquals(graph.hashCode(), newGraph.hashCode());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void hashCode3Test() {
        Vertex<String>[] names = (Vertex<String>[]) new Vertex[3];
        names[0] = new Vertex<>("Tom");
        names[1] = new Vertex<>("Bob");
        names[2] = new Vertex<>("Eva");
        int[][] adjMatrix = new int[names.length][names.length];
        adjMatrix[0] = new int[]{0, 1, 1};
        adjMatrix[1] = new int[]{1, 0, 0};
        adjMatrix[2] = new int[]{1, 0, 0};
        Graph<String> newGraph = new Graph<>(names, adjMatrix);
        Assert.assertNotEquals(graph.hashCode(), newGraph.hashCode());
    }
}
