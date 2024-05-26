import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    /**
     * Initialize a new BreadthFirstSearch object with the given graph and source node.
     * The BFS algorithm is immediately run on the graph starting from the source node.
     *
     * @param graph the graph to perform the BFS algorithm on
     * @param source the source node to start the BFS algorithm from
     */
    public BreadthFirstSearch(MyGraph<V> graph, V source) {
        super(source); // Call the constructor of the superclass Search with the source node
        bfs(graph, source); // Initialize the BFS algorithm with the graph and source node
    }

    /**
     * Perform the BFS algorithm on the given graph starting from the given source node.
     *
     * @param graph the graph to perform the BFS algorithm on
     * @param current the source node to start the BFS algorithm from
     */
    private void bfs(MyGraph<V> graph, V current) {
        marked.add(current);

        Queue<V> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            V v = queue.remove();

            for (V vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}