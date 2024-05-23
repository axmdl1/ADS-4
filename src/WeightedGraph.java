import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> map;

    public WeightedGraph() {
        map = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        if (!map.containsKey(vertex))
            map.put(vertex, new ArrayList<>());
        else
            throw new IllegalArgumentException("Vertex already exists");
    }

    public void addEdge(Vertex source, Vertex dest, Double weight) {
        checkVertex(source);
        checkVertex(dest);
        map.get(source).add(new Edge<>(source, dest, weight));
    }

    private void checkVertex(Vertex vertex) {
        if (!map.containsKey(vertex))
            throw new IndexOutOfBoundsException("Vertex already exists");
    }

    public int countVertices() {
        return map.size();
    }
}