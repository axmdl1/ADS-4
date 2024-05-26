import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a vertex in a graph.
 *
 * @param <V> the type of data stored in the vertex
 */
public class Vertex<V> {
    protected Map<Vertex<V>, Double> adjacentVertices; /* Map to store adjacent vertices and their weights */
    public V data; /* Data stored in the vertex */

    /**
     * Constructs a vertex with the specified data.
     *
     * @param data the data to be stored in the vertex
     */
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Gets the data stored in the vertex.
     *
     * @return the data stored in the vertex
     */
    public V getData() {
        return data;
    }

    /**
     * Sets the data stored in the vertex.
     *
     * @param data the data to be stored in the vertex
     */
    public void setData(V data) {
        this.data = data;
    }

    /**
     * Gets the map of adjacent vertices and their weights.
     *
     * @return the map of adjacent vertices and their weights
     */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    /**
     * Sets the map of adjacent vertices and their weights.
     *
     * @param adjacentVertices the map of adjacent vertices and their weights
     */
    public void setAdjacentVertices(Map<Vertex<V>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    /**
     * Adds an adjacent vertex with the specified weight.
     *
     * @param vertex the adjacent vertex to be added
     * @param weight the weight of the edge to the adjacent vertex
     */
    public void addAdjacentVertex(Vertex<V> vertex, Double weight) {
        adjacentVertices.put(vertex, weight);
    }

    /**
     * Removes the specified adjacent vertex.
     *
     * @param vertex the adjacent vertex to be removed
     */
    public void removeAdjacentVertex(Vertex<V> vertex) {
        adjacentVertices.remove(vertex);
    }

    /**
     * Compares this vertex to the specified object for equality.
     *
     * @param o the object to be compared for equality
     * @return true if the specified object is equal to this vertex, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data) && Objects.equals(adjacentVertices, vertex.adjacentVertices);
    }

    /**
     * Returns the hash code value for this vertex.
     *
     * @return the hash code value for this vertex
     */
    @Override
    public int hashCode() {
        return Objects.hash(data, adjacentVertices);
    }

    /**
     * Returns a string representation of the vertex.
     *
     * @return a string representation of the vertex
     */
    @Override
    public String toString() {
        return "Vertex = " + data + ", adjacentVertices = " + adjacentVertices;
    }
}
