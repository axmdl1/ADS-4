import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private final Map<V, Vertex<V>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        checkVertex(data);
        map.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {
        checkVertex(source);
        checkVertex(dest);

        map.get(source).addAdjacentVertex(map.get(dest), weight);

        if (undirected)
            map.get(dest).addAdjacentVertex(map.get(source), weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public Map<V, Vertex<V>> getMap() {
        return map;
    }

    public void removeEdge(V source, V dest) {
        checkVertex(source);
        checkVertex(dest);

        Vertex<V> sourceVer = map.get(source);
        Vertex<V> destVer = map.get(dest);

        sourceVer.removeAdjacentVertex(destVer);
        if (undirected)
            destVer.removeAdjacentVertex(sourceVer);
    }

    public void checkVertex(V data) {
        if (!map.containsKey(data))
            throw new IndexOutOfBoundsException("Vertex already exists");
    }
}
