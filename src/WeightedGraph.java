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
        if (!map.containsKey(data))
            map.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }

        if (!map.containsKey(dest)) {
            addVertex(dest);
        }

        map.get(source).addAdjacentVertex(map.get(dest), weight);

        if (undirected)
            map.get(dest).addAdjacentVertex(map.get(source), weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public Map<Vertex<V>, Double> adjacencyList(Vertex<V> vertex) {
        return vertex.getAdjacentVertices();
    }

    public Map<V, Vertex<V>> getMap() {
        return map;
    }

    public List<Edge<V>> getEdges(V vertex) {
        hasVertex(vertex);
        List<Edge<V>> edges = new ArrayList<>();
        Vertex<V> v = map.get(vertex);

        for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
            edges.add(new Edge<>(vertex, entry.getKey().getData(), entry.getValue()));
        }

        return edges;
    }

    /*
    public void removeEdge(V source, V dest) {
        hasVertex(source);
        hasVertex(dest);

        Vertex<V> sourceVer = map.get(source);
        Vertex<V> destVer = map.get(dest);

        sourceVer.removeAdjacentVertex(destVer);
        if (undirected)
            destVer.removeAdjacentVertex(sourceVer);
    }
    */

    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }
    /*
    public boolean hasEdge(V source, V dest) {
        if (!(hasVertex(source) && hasVertex(dest))) return false;
        return map.get(source).getAdjacentVertices().containsKey(dest);
    }*/
}
