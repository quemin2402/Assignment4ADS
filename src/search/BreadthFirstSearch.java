package search;

import graph.WeightedGraph;
import search.Search;

import java.util.*;
/**
 * This class implements the Breadth-First search.Search (BFS) algorithm for graphs.
 * Also, it extends the abstract search.Search class, utilizing its structure to perform BFS.
 *
 * @param <V> the vertex type
 */
public class BreadthFirstSearch<V> extends Search<V> {

    /**
     * Method constructs a search.BreadthFirstSearch instance and initiates the BFS process from the source vertex.
     * @param graph the graph on which to perform BFS
     * @param source the starting vertex for BFS
     */
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    /**
     * Executes the BFS algorithm using a queue for managing the vertices.
     * @param graph the graph on which BFS is being executed
     * @param current the starting vertex for BFS
     */
    private void bfs(WeightedGraph<V> graph, V current) {
        Queue<V> queue = new LinkedList<>();
        marked.add(current); // Mark the source vertex as visited
        queue.add(current); // Enqueue the source vertex

        while (!queue.isEmpty()) {
            V v = queue.poll(); // Dequeue a vertex from the queue

            // Process all adjacent vertices of the dequeued vertex
            for (V neighbor : graph.getAdjacencyList(v).keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor); // Mark the neighbor as visited
                    edgeTo.put(neighbor, v); // Store the path to the neighbor
                    queue.add(neighbor); // Enqueue the neighbor
                }
            }
        }
    }
}
