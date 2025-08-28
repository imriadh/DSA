package Lab;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class BFS {

    // Using ArrayList of ArrayLists to represent the adjacency list
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    // Boolean array to keep track of visited nodes
    private static boolean[] visited;
    private static int numNodes = 5;

    // Method to add an edge between two nodes
    public static void addEdge(int u, int v) {
        // Since it's a directed graph in your C++ code, we only add a single edge
        adj.get(u).add(v);
    }

    // BFS implementation
    public static void bfs(int startNode) {
        // LinkedList is a good choice to implement the Queue interface
        Queue<Integer> q = new LinkedList<>();
        
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int u = q.poll(); // poll() retrieves and removes the head of the queue
            System.out.print(u + " ");

            // Get the list of neighbors for the current node 'u'
            for (int neighbor : adj.get(u)) {
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Initialize the graph structure
        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }

        // Initialize the visited array
        visited = new boolean[numNodes];

        // Add edges to the graph
        addEdge(0, 2);
        addEdge(0, 1);
        addEdge(1, 3);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(2, 4);

        // Perform BFS starting from node 0
        System.out.println("BFS Traversal starting from node 0:");
        bfs(0);
    }
}