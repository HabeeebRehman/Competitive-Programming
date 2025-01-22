import java.util.*;

public class Q2 {
    static class Edge implements Comparable<Edge> {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static void primsMST(int n, List<List<Edge>> graph) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int mstWeight = 0;

        // Start from vertex 0
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.dest;

            // Skip if already visited
            if (visited[u]) continue;
            visited[u] = true;
            mstWeight += current.weight;

            // Add all adjacent edges
            for (Edge neighbor : graph.get(u)) {
                if (!visited[neighbor.dest]) {
                    pq.add(neighbor);
                }
            }
        }

        System.out.println("Weight of the MST: " + mstWeight);
    }

    public static void main(String[] args) {
        int n = 5; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected)
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(3, 6));
        graph.get(1).add(new Edge(0, 2));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 8));
        graph.get(1).add(new Edge(4, 5));
        graph.get(2).add(new Edge(1, 3));
        graph.get(2).add(new Edge(4, 7));
        graph.get(3).add(new Edge(0, 6));
        graph.get(3).add(new Edge(1, 8));
        graph.get(4).add(new Edge(1, 5));
        graph.get(4).add(new Edge(2, 7));

        primsMST(n, graph);
    }
}
