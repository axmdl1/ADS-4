import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distTo;
    private PriorityQueue<VertexDist<V>> pq;

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

    private void relax(V v, V w, double weight) {
        if (distTo.get(w) > distTo.get(v) + weight) {
            distTo.put(w, distTo.get(v) + weight);
            edgeTo.put(w, v);
            pq.add(new VertexDist<>(w, distTo.get(w)));
        }
    }

    @Override
    public boolean hasPathTo(V destination) {
        return distTo.get(destination) < Double.POSITIVE_INFINITY;
    }

    private static class VertexDist<V> {
        private V vertex;
        private double dist;

        public VertexDist(V vertex, double dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        public V getVertex() {
            return vertex;
        }

        public double getDist() {
            return dist;
        }
    }
}