package Lab;

import java.util.Stack;
import java.util.ArrayList;

public class DFS {

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

    // DFS implementation
    public static void dfs(int startNode) {
        // The Stack class provides LIFO functionality
        Stack<Integer> stk = new Stack<>();
        
        stk.push(startNode);
        visited[startNode] = true;

        while (!stk.isEmpty()) {
            int u = stk.pop(); // pop() retrieves and removes the element at the top
            System.out.print(u + " ");
            
            // Get the list of neighbors for the current node 'u'
            // We iterate in reverse to match the C++ output
            for (int i = adj.get(u).size() - 1; i >= 0; i--) {
                int neighbor = adj.get(u).get(i);
                if (!visited[neighbor]) {
                    stk.push(neighbor);
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

        // Perform DFS starting from node 0
        System.out.println("DFS Traversal starting from node 0:");
        dfs(0);
    }
}