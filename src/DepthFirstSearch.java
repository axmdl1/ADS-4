public class DepthFirstSearch<V> extends Search<V> {

    /**
     * Initialize a new DepthFirstSearch object with the given graph and source node.
     * The DFS algorithm is immediately run on the graph starting from the source node.
     *
     * @param graph the graph to perform the DFS algorithm on
     * @param source the source node to start the DFS algorithm from
     */
    public DepthFirstSearch(MyGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    /**
     * Perform the DFS algorithm on the given graph starting from the given source node.
     *
     * @param graph the graph to perform the DFS algorithm on
     * @param current the current node to visit in the graph
     */
    private void dfs(MyGraph<V> graph, V current) {
        marked.add(current);

        for (V v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}