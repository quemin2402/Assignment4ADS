import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V current) {
        Queue<V> queue = new LinkedList<>();
        marked.add(current);
        queue.add(current);

        while (!queue.isEmpty()) {
            V v = queue.poll();

            for (V neighbor : graph.getAdjacencyList(v).keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, v);
                    queue.add(neighbor);
                }
            }
        }
    }
}
