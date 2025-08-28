package graph;

public class MainGraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.println("BFS from 0: " + Graph.fmt(g.bfs(0)));
        // System.out.println("DFS recursive from 0: " + Graph.fmt(g.dfsRecursive(0)));
        System.out.println("DFS iterative from 0: " + Graph.fmt(g.dfsIterative(0)));
    }
}
