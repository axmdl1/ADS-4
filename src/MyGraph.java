import java.util.*;

/**
 * Represents a generic graph structure.
 *
 * @param <V> the type of the vertices in the graph
 */
public class MyGraph<V> {
    private final boolean undirected;
    private final Map<V, List<V>> map = new HashMap<>();

    /**
     * Constructs a graph.
     */
    public MyGraph() {
        this(true);
    }

    /**
     * Constructs a graph with the specified type.
     *
     * @param undirected true if the graph is undirected, false otherwise
     */
    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param v the vertex to be added
     */
    public void addVertex(V v) {
        if (hasVertex(v))
            return;

        map.put(v, new LinkedList<>());
    }

    /**
     * Adds an edge between two vertices in the graph.
     *
     * @param source the source vertex of the edge
     * @param dest   the destination vertex of the edge
     */
    public void addEdge(V source, V dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(dest);

        if (undirected)
            map.get(dest).add(source);
    }

    /**
     * Gets the number of vertices in the graph.
     *
     * @return the number of vertices
     */
    public int getVerticesCount() {
        return map.size();
    }

    /**
     * Gets the number of edges in the graph.
     *
     * @return the number of edges
     */
    public int getEdgesCount() {
        int count = 0;
        for (V v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    /**
     * Checks if the graph contains a vertex.
     *
     * @param v the vertex to check
     * @return true if the graph contains the vertex, false otherwise
     */
    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    /**
     * Checks if there is an edge between two vertices in the graph.
     *
     * @param source the source vertex of the edge
     * @param dest   the destination vertex of the edge
     * @return true if there is an edge between the vertices, false otherwise
     */
    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    /**
     * Gets the adjacency list of a vertex.
     *
     * @param v the vertex
     * @return the adjacency list of the vertex, or null if the vertex is not in the graph
     */
    public List<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;

        return map.get(v);
    }
}
