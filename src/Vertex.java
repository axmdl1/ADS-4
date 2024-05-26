import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    protected Map<Vertex<V>, Double> adjacentVertices;
    public V data;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<Vertex<V>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public void addAdjacentVertex(Vertex<V> vertex, Double weight) {
        adjacentVertices.put(vertex, weight);
    }

    public void removeAdjacentVertex(Vertex<V> vertex) {
        adjacentVertices.remove(vertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data) && Objects.equals(adjacentVertices, vertex.adjacentVertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, adjacentVertices);
    }

    @Override
    public String toString() {
        return "Vertex = " + data + ", adjacentVertices = " + adjacentVertices;
    }
}
