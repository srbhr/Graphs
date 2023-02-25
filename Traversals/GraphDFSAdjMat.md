# Depth First Search Using Adjacency Matrix 

## DFS Algorithm

The general process of exploring a graph using depth first search includes the following steps:-

-Take the input for the adjacency matrix or adjacency list for the graph.  
-Initialize a stack.  
-Push the root node (in other words, put the root node into the beginning of the stack).  
-If the root node has no neighbors, stop here.   
-Else push the leftmost neighboring node which hasn’t already been explored into the stack.   
-Continue this process till a node is encountered which has no neighbors (or whose neighbors have all been added to the stack already)   
– stop the process then, pop the head, and then continue the process for the node which is popped.  
-Keep repeating this process till the stack becomes empty.  

```java

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
```
## Time & space Complexity 

The running time complexity of the DFS algorithm in java is O(V+E) where V is the number of nodes in the graph, and E is the number of edges.  

Since the algorithm requires a stack for storing the nodes that need to be traversed at any point in time, the space complexity is the maximum size of the stack at any point of time. Since this can extend to V slots for a linear graph, the maximum space complexity is O(V).  
