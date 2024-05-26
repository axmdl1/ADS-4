import java.util.*;

/**
 * An abstract class representing a search algorithm in a graph.
 *
 * @param <V> the type of the nodes in the graph
 */
public abstract class Search<V> {
    protected Set<V> marked; /* Set to store visited nodes */
    protected Map<V, V> edgeTo; /* Map to store the edge leading to each node */
    protected final V source; /* The source node for the search */

    /**
     * Constructs a search object with the given source node.
     *
     * @param source the source node for the search
     */
    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    /**
     * Checks if there is a path from the source node to the given destination node.
     *
     * @param destination the destination node to check the path to
     * @return true if there is a path to the destination, false otherwise
     */
    public boolean hasPathTo(V destination) {
        return marked.contains(destination);
    }

    /**
     * Returns a path from the source node to the given destination node.
     *
     * @param destination the destination node
     * @return a list representing the path from the source to the destination,
     *         or null if there is no path
     */
    public List<V> pathTo(V destination) {
        if (!hasPathTo(destination)) {
            return null;
        }
        List<V> path = new LinkedList<>();
        for (V x = destination; x != null; x = edgeTo.get(x)) {
            path.add(x);
        }
        Collections.reverse(path);
        return path;
    }
}
