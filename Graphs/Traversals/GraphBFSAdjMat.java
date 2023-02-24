
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSAdjMat {
    private int vertices; // Number of vertices in the graph
    private int[][] adjacencyMatrix; // Adjacency matrix to store graph edges

    // Constructor to create an empty graph
    public GraphBFSAdjMat(int v) {
        vertices = v;
        adjacencyMatrix = new int[v][v];
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // If the graph is undirected
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

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true; // Mark the adjacent vertex as visited
                    queue.add(i); // Enqueue the adjacent vertex
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a new graph with 5 vertices
        GraphBFSAdjMat g = new GraphBFSAdjMat(5);

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
