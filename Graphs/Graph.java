import java.util.Scanner;

public class Graph {

    public static void printDepthFS(int[][] edges, int startingVertex, boolean[] visited) {
        System.out.println(startingVertex);
        visited[startingVertex] = true;
        int n = edges.length;

        for (int i = 0; i < n; i++) {
            if (edges[startingVertex][i] == 1 && !visited[i]) {
                printDepthFS(edges, i, visited);
            }
        }
    }

    public static void printDFSHelper(int[][] edges) {
        boolean[] visited = new boolean[edges.length]; // 8
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                System.out.println("DFS Called");
                printDepthFS(edges, i, visited);
            }
        }
    }

    public static void main(String[] args) {

        int n; // vertices
        int e; // edges
        Scanner sc = new Scanner(System.in);
        // Get the number of nodes and edges in the graph so far.
        // Note: max no of edges = n(n-1)/2, min no = 0
        n = sc.nextInt();
        e = sc.nextInt();
        int [][] edges = new int[n][n];

        // Inserting the values in the Adjacency Matrix.
        for (int i = 0; i < e; i++) {
        int vertexOne = sc.nextInt();
        int vertexTwo = sc.nextInt();
        edges[vertexOne][vertexTwo] = 1;
        edges[vertexTwo][vertexOne] = 1; // mirror is also added right here.
        }
        printDFSHelper(edges);
    }
}