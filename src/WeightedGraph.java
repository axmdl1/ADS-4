import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private final Map<V, Vertex<V>> map;
    private boolean undirected;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.map = new HashMap<>();
    }

    /**
     * Adds a vertex with the specified data to the graph.
     *
     * @param data the data of the vertex to be added
     */
    public void addVertex(V data) {
        map.put(data, new Vertex<>(data));
    }

    /**
     * Adds a weighted edge between two vertices in the graph.
     *
     * @param source      the source vertex of the edge
     * @param destination the destination vertex of the edge
     * @param weight      the weight of the edge
     */
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

    /**
     * Retrieves the vertex associated with the specified data.
     *
     * @param data the data of the vertex to retrieve
     * @return the vertex associated with the specified data, or null if not found
     */
    public Vertex<V> getVertex(V data) {
        return map.get(data);
    }

    /**
     * Retrieves a map containing all vertices in the graph.
     *
     * @return a map containing all vertices in the graph
     */
    public Map<V, Vertex<V>> getVertices() {
        return map;
    }

}