import java.util.Stack;

public class GraphDFSAdjMat {

    private int vertices; // Number of vertices in the graph
    private int[][] adjacencyMatrix; // Adjacency matrix to store graph edges

    // Constructor to create an empty graph
    public GraphDFSAdjMat(int v) {
        vertices = v;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // If the graph is undirected
    }

    // Method to perform DFS on the graph
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        // Mark the start vertex as visited and push it onto the stack
        visited[startVertex] = true;
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            // Pop a vertex from the stack and print it
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            // Get all adjacent vertices of the current vertex
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    // Mark the adjacent vertex as visited and push it onto the stack
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a new graph with 5 vertices
        GraphDFSAdjMat g = new GraphDFSAdjMat(5);

        // Add some edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // Perform DFS starting from vertex 2
        System.out.println("Depth-First Search:");
        g.dfs(2);
    }

}
