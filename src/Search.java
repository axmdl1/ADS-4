import java.util.*;

public abstract class Search<V> {
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected final V source;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V destination) {
        return marked.contains(destination);
    }

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
