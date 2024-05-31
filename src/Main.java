import graph.WeightedGraph;
import search.BreadthFirstSearch;
import search.DijkstraSearch;
import search.Search;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(false);
        fillGraphWithWeights(graph);

        System.out.println("Breadth-First Search:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");

        System.out.println("--------------------------------");

        System.out.println("Dijkstra Search:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "Almaty");
        outputPath(dijkstra, "Kyzylorda");

    }

    public static void fillGraphWithWeights(WeightedGraph<String> graph) {
        String[] cities = {"Almaty", "Astana", "Shymkent", "Atyrau", "Kostanay", "Kyzylorda"};
        for (String city : cities) {
            graph.addVertex(city);
        }

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void outputPath(Search<String> search, String destination) {
        System.out.println("Path from " + search.getSource() + " to " + destination + ":");
        Iterable<String> path = search.pathTo(destination);
        if (path == null) {
            System.out.println("No path available.");
        } else {
            for (String v : path) {
                System.out.print(v + " -> ");
            }
            System.out.println("end");
        }
        System.out.println();
    }
}
