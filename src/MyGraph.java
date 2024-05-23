import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {
    private final Map<Vertex, List<Vertex>> map;

    public MyGraph() {
        map = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        if (!map.containsKey(vertex))
            map.put(vertex, new LinkedList<>());
        else
            throw new IllegalArgumentException("Vertex already exists!");
    }

    public void addEdge(Vertex source, Vertex dest) {
        checkVertex(source);
        checkVertex(dest);

        map.get(source).add(dest);
        map.get(dest).add(source);
    }

    public int countVertices(){
        return map.size();
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        checkVertex(source);
        checkVertex(dest);
        List<Vertex> neighbors = getNeighbors(source);
        return neighbors != null && neighbors.contains(dest);
    }

    public List<Vertex> getNeighbors(Vertex vertex) {
        return map.get(vertex);
    }

    private void checkVertex(Vertex vertex) {
        if (!map.containsKey(vertex)){
            throw new IndexOutOfBoundsException("Vertex not found");
        }
    }

    public void printGraph() {
        for (Vertex vertex : map.keySet()) {
            System.out.println("Vertex: " + vertex + " connected: " + getNeighbors(vertex));
        }
    }

    public void removeEdge(Vertex source, Vertex dest) {
        checkVertex(source);
        checkVertex(dest);

        map.get(source).remove(dest);
        map.get(dest).remove(source);
    }

    public void removeVertex(Vertex vertex) {
        checkVertex(vertex);
        for (Vertex neighbor : getNeighbors(vertex)){
            map.get(neighbor).remove(vertex);
        }
        map.remove(vertex);
        System.out.println("Vertex -> " + vertex + " removed");
    }
}
