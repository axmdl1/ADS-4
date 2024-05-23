import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacencyVertices;

    public void addAdjacentVertex(Vertex<V> dest, double weight){
        adjacencyVertices.put(dest, weight);
    }
}
