import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSAdjList {
    private int vertices; // Number of vertices in the graph
    private ArrayList<Integer>[] adjacencyList; // Adjacency list to store graph edges

    // Constructor to create an empty graph
    public GraphBFSAdjList(int v) {
        vertices = v;
        adjacencyList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // If the graph is undirected
    }

    // Method to perform BFS on the graph
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices]; // Initialize all vertices as not visited
        Queue<Integer> queue = new LinkedList<>(); // Create a queue for BFS

        visited[start] = true; // Mark the starting vertex as visited
        queue.add(start); // Enqueue the starting vertex

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Dequeue a vertex from the queue
            System.out.print(current + " ");

            for (int i = 0; i < adjacencyList[current].size(); i++) {
                int next = adjacencyList[current].get(i);
                if (!visited[next]) {
                    visited[next] = true; // Mark the adjacent vertex as visited
                    queue.add(next); // Enqueue the adjacent vertex
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a new graph with 5 vertices
        GraphBFSAdjList g = new GraphBFSAdjList(5);

        // Add some edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // Perform BFS starting from vertex 2
        System.out.println("BFS:");
        g.bfs(2);
    }
}