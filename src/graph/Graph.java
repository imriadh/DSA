package graph;

import java.util.*;

public class Graph {
    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    // add undirected edge
    public void addEdge(int u, int v) {
        if (u < 0 || u >= V || v < 0 || v >= V) throw new IndexOutOfBoundsException("Vertex out of range");
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Breadth-first search from start vertex
    public List<Integer> bfs(int start) {
        boolean[] visited = new boolean[V];
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            order.add(u);
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return order;
    }

    // DFS (recursive)
    // public List<Integer> dfsRecursive(int start) {
    //     boolean[] visited = new boolean[V];
    //     List<Integer> order = new ArrayList<>();
    //     dfsHelper(start, visited, order);
    //     return order;
    // }

    // private void dfsHelper(int u, boolean[] visited, List<Integer> order) {
    //     visited[u] = true;
    //     order.add(u);
    //     for (int v : adj.get(u)) {
    //         if (!visited[v]) dfsHelper(v, visited, order);
    //     }
    // }

    // DFS (iterative using stack)
    public List<Integer> dfsIterative(int start) {
        boolean[] visited = new boolean[V];
        List<Integer> order = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (visited[u]) continue;
            visited[u] = true;
            order.add(u);
            // push neighbours in reverse to mimic recursive order
            List<Integer> neighbors = adj.get(u);
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int v = neighbors.get(i);
                if (!visited[v]) stack.push(v);
            }
        }
        return order;
    }

    // small helper to format output
    public static String fmt(List<Integer> list) {
        return list.toString();
    }
}
