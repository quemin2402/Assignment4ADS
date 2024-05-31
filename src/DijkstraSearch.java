import java.util.*;
/**
 * Implements the Dijkstra's algorithm for finding the shortest paths from a single source vertex
 * to all other vertices in a weighted graph.
 *
 * @param <V> the type of vertices in the graph
 */
public class DijkstraSearch<V> extends Search<V> {
    private final Map<V, Double> distances; // Stores the shortest distance from the source to each vertex
    private final PriorityQueue<V> pq; // Priority queue to select the vertex with the minimum distance
    private final WeightedGraph<V> graph; // The graph on which the search is performed

    /**
     * Constructs a DijkstraSearch instance and initializes the search process.
     * @param graph The weighted graph on which to perform the search
     * @param source The starting vertex for the pathfinding
     */
    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        this.graph = graph;
        distances = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        dijkstra();
    }

    /**
     * Executes the Dijkstra algorithm using a priority queue to efficiently find the shortest path
     * from the source to all vertices in the graph.
     */
    private void dijkstra() {
        distances.put(source, 0.0); // Distance from the source to itself is always 0
        pq.add(source); // Start with the source vertex

        while (!pq.isEmpty()) {
            V currentNode = pq.poll(); // Get the vertex with the smallest distance

            // Process each adjacent vertex of the current node
            for (V neighbor : graph.getAdjacencyList(currentNode).keySet()) {
                double newDistance = distances.get(currentNode) + graph.getWeight(currentNode, neighbor);

                // If a shorter path to the neighbor is found, update the distance and path
                if (newDistance < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    pq.add(neighbor); // Re-add the neighbor to the priority queue with the new distance
                }
            }
        }
    }

    /**
     * Retrieves the shortest distance to a given vertex from the source vertex.
     * @param destination The vertex to which the shortest distance is calculated
     * @return The shortest distance from the source to the destination vertex
     */
    private double getShortestDistance(V destination) {
        return distances.getOrDefault(destination, Double.MAX_VALUE);
    }

    /**
     * Determines if a path exists from the source vertex to the specified vertex.
     * @param v The vertex to check for connectivity
     * @return true if there is a path from the source to vertex v, otherwise false
     */
    @Override
    public boolean hasPathTo(V v) {
        return distances.containsKey(v);
    }
}
