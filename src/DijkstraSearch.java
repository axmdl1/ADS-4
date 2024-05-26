import java.util.*;

/**
 * This class implements Dijkstra's algorithm for finding the shortest paths from a source node
 * to all other nodes in a weighted graph.
 *
 * @param <V> the type of the nodes in the graph
 */
public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distTo;
    private PriorityQueue<VertexDist<V>> pq;

    /**
     * Initializes a new DijkstraSearch object with the given weighted graph and source node.
     * The Dijkstra algorithm is immediately run on the graph starting from the source node.
     *
     * @param graph the weighted graph to perform the Dijkstra algorithm on
     * @param start the source node to start the Dijkstra algorithm from
     */
    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(start);
        distTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(VertexDist::getDist));

        for (V vertex : graph.getVertices().keySet()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);

        pq.add(new VertexDist<>(start, 0.0));
        while (!pq.isEmpty()) {
            VertexDist<V> vertexDist = pq.poll();
            V v = vertexDist.getVertex();
            for (Map.Entry<Vertex<V>, Double> entry : graph.getVertex(v).getAdjacentVertices().entrySet()) {
                relax(v, entry.getKey().getData(), entry.getValue());
            }
        }
    }

    /**
     * Relaxes the edge between two nodes if a shorter path is found.
     *
     * @param v the current node
     * @param w the adjacent node to be relaxed
     * @param weight the weight of the edge between v and w
     */
    private void relax(V v, V w, double weight) {
        if (distTo.get(w) > distTo.get(v) + weight) {
            distTo.put(w, distTo.get(v) + weight);
            edgeTo.put(w, v);
            pq.add(new VertexDist<>(w, distTo.get(w)));
        }
    }

    /**
     * Checks if there is a path from the source node to the given destination node.
     *
     * @param destination the destination node to check the path to
     * @return true if there is a path to the destination, false otherwise
     */
    @Override
    public boolean hasPathTo(V destination) {
        return distTo.get(destination) < Double.POSITIVE_INFINITY;
    }

    /**
     * A helper class to store nodes and their corresponding distances in the priority queue.
     *
     * @param <V> the type of the node
     */
    private static class VertexDist<V> {
        private V vertex;
        private double dist;

        /**
         * Constructs a VertexDist object.
         *
         * @param vertex the node
         * @param dist the distance to the node
         */
        public VertexDist(V vertex, double dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        /**
         * Returns the node.
         *
         * @return the node
         */
        public V getVertex() {
            return vertex;
        }

        /**
         * Returns the distance to the node.
         *
         * @return the distance to the node
         */
        public double getDist() {
            return dist;
        }
    }
}
