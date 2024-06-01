# Assignment 4, ADS course

## Description
This project is an implementation of various graph search algorithms in Java, focusing on Dijkstra's algorithm for finding the shortest paths in a weighted graph and Breadth-First Search (BFS) for exploring the graph. The project aims to demonstrate practical applications of these algorithms using a custom graph structure.

## Structure and Description of Classes

### `Vertex<V>`
- **Description**: Represents a vertex in a graph with a generic type `V`. Stores data and a map of adjacent vertices along with their edge weights.
- **Methods**:
  - `addAdjacentVertex(Vertex<V> destination, double weight)`: Adds an edge to an adjacent vertex with a specified weight.
  - `getData()`: Returns the data stored in the vertex.
  - `getAdjacentVertices()`: Returns a map of adjacent vertices and their edge weights.

### `WeightedGraph<V>`
- **Description**: Manages a generic weighted graph, storing vertices and their edges with weights.
- **Methods**:
  - `addVertex(V vertex)`: Adds a vertex to the graph.
  - `addEdge(V source, V destination, double weight)`: Adds an edge between two vertices with a specified weight.
  - `removeEdge(V source, V destination)`: Removes an edge between two vertices.
  - `hasVertex(V vertex)`, `hasEdge(V source, V destination)`: Check existence of vertices and edges.
  - `getWeight(V source, V destination)`: Retrieves the weight of an edge between two vertices.
  - `getAdjacencyList(V vertex)`: Provides a map of all adjacent vertices and their weights.

### `Search<V>`
- **Description**: Abstract base class for search algorithms.
- **Methods**:
  - `hasPathTo(V v)`: Determines whether there is a path to the specified vertex.
  - `pathTo(V v)`: Returns an iterable path from the source to the specified vertex, if it exists.

### `BreadthFirstSearch<V>`
- **Description**: Implements the Breadth-First Search algorithm.
- **Method**:
  - `bfs(WeightedGraph<V> graph, V current)`: Executes the BFS algorithm using a queue.

### `DijkstraSearch<V>`
- **Description**: Implements Dijkstra's algorithm.
- **Method**:
  - `dijkstra()`: Executes the Dijkstra algorithm using a priority queue to find the shortest path.

## Example Usage

The project includes a `Main` class that demonstrates the use of the `WeightedGraph`, `BreadthFirstSearch`, and `DijkstraSearch` on a predefined set of cities and connections.

### Group: SE-2308
### Student: Merey Ibraim
