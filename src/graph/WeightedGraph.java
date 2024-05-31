package graph;

import java.util.*;
/**
 * WeighedGraph class represents a generic weighted graph.
 * Stores vertices and their edges with weights.
 */
public class WeightedGraph<V> {
    private Map<V, Map<V, Double>> adjacencyMap;
    private boolean isDirected;

    /**
     * Constructs a new graph.WeightedGraph.
     * @param isDirected true if the graph is directed, false if undirected.
     */
    public WeightedGraph(boolean isDirected) {
        this.adjacencyMap = new HashMap<>();
        this.isDirected = isDirected;
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex The vertex to add.
     */
    public void addVertex(V vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }

    /**
     * Adds an edge between two vertices with a specified weight.
     * If the graph is undirected, adds an edge in both directions.
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @param weight The weight of the edge.
     */
    public void addEdge(V source, V destination, double weight) {
        this.addVertex(source);
        this.addVertex(destination);
        adjacencyMap.get(source).put(destination, weight);
        if (!isDirected) {
            adjacencyMap.get(destination).put(source, weight);
        }
    }

    /**
     * Removes an edge between two vertices.
     * @param source The source vertex.
     * @param destination The destination vertex.
     */
    public void removeEdge(V source, V destination) {
        if (adjacencyMap.containsKey(source)) {
            adjacencyMap.get(source).remove(destination);
        }
        if (!isDirected && adjacencyMap.containsKey(destination)) {
            adjacencyMap.get(destination).remove(source);
        }
    }

    /**
     * Removes a vertex and all its associated edges from the graph.
     * @param vertex The vertex to remove.
     */
    public void removeVertex(V vertex) {
        if (!adjacencyMap.containsKey(vertex)) return;
        adjacencyMap.values().forEach(e -> e.remove(vertex));
        adjacencyMap.remove(vertex);
    }

    /**
     * Checks if a vertex exists in the graph.
     * @param vertex The vertex to check.
     * @return true if the vertex exists, false otherwise.
     */
    public boolean hasVertex(V vertex) {
        return adjacencyMap.containsKey(vertex);
    }

    /**
     * Checks if an edge exists between two vertices.
     * This method confirms the presence of a directed or undirected edge,
     * depending on the type of the graph.
     *
     * @param source The source vertex from which the edge originates.
     * @param destination The destination vertex where the edge terminates.
     * @return true if the edge exists, false otherwise.
     */
    public boolean hasEdge(V source, V destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).containsKey(destination);
    }

    /**
     * Retrieves the weight of the edge between two specified vertices.
     *
     * @param source The vertex from which the edge originates.
     * @param destination The vertex to which the edge is directed.
     * @return The weight of the edge if it exists, otherwise throws a RuntimeException.
     */
    public double getWeight(V source, V destination) {
        return adjacencyMap.get(source).get(destination);
    }

    /**
     * Provides a map of all vertices adjacent to a specified vertex along with the weights of the connecting edges.
     * This method is useful for algorithms that need to access all direct neighbors of a vertex,
     * such as Dijkstra's or BFS.
     *
     * @param vertex The vertex whose adjacency list is to be retrieved.
     * @return A map of adjacent vertices and their corresponding edge weights.
     */
    public Map<V, Double> getAdjacencyList(V vertex) {
        return adjacencyMap.get(vertex);
    }

    /**
     * Counts the total number of vertices in the graph.
     *
     * @return The total number of vertices.
     */
    public int getVerticesCount() {
        return adjacencyMap.size();
    }

    /**
     * Counts the total number of edges in the graph. If the graph is undirected,
     * each edge is counted once for both connected vertices.
     *
     * @return The total number of edges in the graph.
     */
    public int getEdgesCount() {
        int count = adjacencyMap.values().stream().mapToInt(Map::size).sum();
        return isDirected ? count : count / 2;
    }
}
