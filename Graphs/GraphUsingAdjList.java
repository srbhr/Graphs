import java.util.ArrayList;

public class GraphUsingAdjList {

    private int vertices; // Number of vertices in the graph
    private ArrayList<ArrayList<Integer>> adjacencyList; // Adjacency list to store graph edges

    // Constructor to create an empty graph
    public GraphUsingAdjList(int v) {
        vertices = v;
        adjacencyList = new ArrayList<>(v);

        // Create an empty list for each vertex
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // If the graph is undirected
    }

    public static void main(String[] args) {
        // Create a new graph with 5 vertices
        GraphUsingAdjList g = new GraphUsingAdjList(5);

        // Add some edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // Print the adjacency list of the graph
        System.out.println("Adjacency List:");
        for (int i = 0; i < g.vertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < g.adjacencyList.get(i).size(); j++) {
                System.out.print(g.adjacencyList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
