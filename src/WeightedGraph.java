import java.util.*;

public class WeightedGraph<V> {
    private Map<V, Map<V, Double>> adjacencyMap;
    private boolean isDirected;

    public WeightedGraph(boolean isDirected) {
        this.adjacencyMap = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addVertex(V vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(V source, V destination, double weight) {
        this.addVertex(source);
        this.addVertex(destination);

        adjacencyMap.get(source).put(destination, weight);

        if (!isDirected) {
            adjacencyMap.get(destination).put(source, weight);
        }
    }

    public void removeEdge(V source, V destination) {
        if (adjacencyMap.containsKey(source)) {
            adjacencyMap.get(source).remove(destination);
        }
        if (!isDirected && adjacencyMap.containsKey(destination)) {
            adjacencyMap.get(destination).remove(source);
        }
    }

    public void removeVertex(V vertex) {
        if (!adjacencyMap.containsKey(vertex)) return;

        adjacencyMap.values().forEach(e -> e.remove(vertex));
        adjacencyMap.remove(vertex);
    }

    public boolean hasVertex(V vertex) {
        return adjacencyMap.containsKey(vertex);
    }

    public boolean hasEdge(V source, V destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).containsKey(destination);
    }

    public double getWeight(V source, V destination) {
        return adjacencyMap.get(source).get(destination);
    }

    public Map<V, Double> getAdjacencyList(V vertex) {
        return adjacencyMap.get(vertex);
    }

    public int getVerticesCount() {
        return adjacencyMap.size();
    }

    public int getEdgesCount() {
        int count = adjacencyMap.values().stream().mapToInt(Map::size).sum();
        return isDirected ? count : count / 2;
    }
}
