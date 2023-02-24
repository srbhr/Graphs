public class GraphUsingAdjacencyMatrix {
    private int vertices; // Number of vertices in the graph
    private int[][] adjacencyMatrix; // Adjacency matrix to store graph edges

    // Constructor to create an empty graph
    public GraphUsingAdjacencyMatrix(int v) {
        vertices = v;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // If the graph is undirected
    }

    // Method to print the adjacency matrix
    public void printAdjacencyMatrix() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a new graph with 5 vertices
        GraphUsingAdjacencyMatrix g = new GraphUsingAdjacencyMatrix(5);

        // Add some edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        // Print the adjacency matrix
        g.printAdjacencyMatrix();
    }

}
