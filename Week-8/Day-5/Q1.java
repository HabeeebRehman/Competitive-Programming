import java.util.*;

public class Q1 {
    public static int[] dijkstra(int n, int[][] graph, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int d = current[1];

            if (d > dist[node]) continue;

            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] graph = {
            {{1, 2}, {2, 1}},
            {{0, 2}, {2, 3}, {3, 1}},
            {{0, 1}, {1, 3}, {4, 6}},
            {{1, 1}, {2, 3}},
            {{2, 6}}
        };
        int[] dist = dijkstra(n, graph, 0);
        System.out.println("Shortest distances from node 0: " + Arrays.toString(dist));
    }
}
