import java.util.HashMap;
import java.util.Map;
/**
 * This class represents a vertex in a graph with generic type V.
 * Stores data of type V and a map of adjacent vertices with their edge weights.
 */
public class Vertex<V> {
    private V data; // Data stored in the vertex
    private Map<Vertex<V>, Double> adjacentVertices; // Adjacent vertices with their weights

    /**
     * Constructs a new Vertex with the specified data.
     * @param data Data to be stored in the vertex.
     */
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Adds an edge to an adjacent vertex with a specified weight.
     * @param destination The vertex that this vertex is connected to by the edge.
     * @param weight The weight of the edge.
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    /**
     * Returns the data stored in this vertex.
     * @return Data of type V.
     */
    public V getData() {
        return data;
    }

    /**
     * Returns a map of adjacent vertices and their edge weights.
     * @return Map of adjacent vertices.
     */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
