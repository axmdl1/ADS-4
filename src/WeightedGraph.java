import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }
}