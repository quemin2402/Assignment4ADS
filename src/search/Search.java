package search;

import java.util.*;
/**
 * Abstract base class for search algorithms in graphs.
 * Provides common fields and methods for search operations.
 *
 * @param <V> the vertex type
 */
public abstract class Search<V> {
    protected Set<V> marked; // Set of marked vertices to track visited nodes
    protected Map<V, V> edgeTo; // Map to track the path from the source vertex to each visited vertex
    protected final V source;  // The source vertex from which to start the search

    /**
     * Constructor initializes the search with a source vertex.
     * @param source the source vertex from which the search starts
     */
    public Search(V source) {
        this.source = source;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    /**
     * Determines whether there is a path to the specified vertex.
     * @param v the vertex to check
     * @return true if there is a path from the source to vertex v
     */
    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    /**
     * Returns an iterable path from the source to the specified vertex, if it exists.
     * @param v the vertex to which to find the path
     * @return an iterable object containing the path from the source to vertex v, or null if no path exists
     */
    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = v; x != source; x = edgeTo.get(x)) {
            path.push(x);
        }
        path.push(source);
        return path;
    }

    public V getSource() {
        return source;
    }
}
