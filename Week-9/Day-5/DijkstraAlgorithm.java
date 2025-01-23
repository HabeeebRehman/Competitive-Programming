import java.util.*;

public class DijkstraAlgorithm {
    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;
        List<List<Edge>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int weight) {
            adj.get(u).add(new Edge(v, weight));
            adj.get(v).add(new Edge(u, weight));  // For undirected graph, remove this line for directed
        }

        void dijkstra(int src) {
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[] { src, 0 });

            while (!pq.isEmpty()) {
                int[] u = pq.poll();
                int node = u[0], distance = u[1];

                if (distance > dist[node]) continue;

                for (Edge e : adj.get(node)) {
                    int v = e.dest, weight = e.weight;
                    if (dist[node] + weight < dist[v]) {
                        dist[v] = dist[node] + weight;
                        pq.add(new int[] { v, dist[v] });
                    }
                }
            }

            // Print the shortest distances
            for (int i = 0; i < V; i++) {
                System.out.println("Distance from " + src + " to " + i + ": " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 9);
        g.addEdge(3, 4, 4);
        
        g.dijkstra(0);  // Find shortest path from node 0
    }
}
