import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Vertex>> map = new HashMap<>();

    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex vertex) {
        if (hasVertex(vertex))
            return;
        
        map.put(vertex, new LinkedList<>()); 
    }

    public void addEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return;

        map.get(source).add(dest);

        if (undirected)
            map.get(dest).add(source);
    }

    private boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source))
            return false;
        return map.get(source).contains(dest);
    }

    private boolean hasVertex(Vertex vertex) {
        return map.containsKey(vertex);
    }

}
