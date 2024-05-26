import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> map;
    private boolean undirected;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.map = new HashMap<>();
    }

    public void addVertex(V data) {
        map.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V destination, double weight) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(destination)) {
            addVertex(destination);
        }
        map.get(source).addAdjacentVertex(map.get(destination), weight);
        if (undirected) {
            map.get(destination).addAdjacentVertex(map.get(source), weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return map.get(data);
    }

    public Map<V, Vertex<V>> getVertices() {
        return map;
    }
}