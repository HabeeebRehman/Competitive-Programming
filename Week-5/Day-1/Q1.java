import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 4, 0, 0, 0}, {1, 0, 4, 2, 7, 0}, {4, 4, 0, 3, 5, 0}, {0, 2, 3, 0, 4, 6}, {0, 7, 5, 4, 0, 7}, {0, 0, 0, 6, 7, 0}};
        System.out.println(dijkstra(graph, 0));
    }

    public static int[] dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], weight = curr[1];
            for (int i = 0; i < n; i++) {
                if (graph[node][i] != 0 && dist[node] + graph[node][i] < dist[i]) {
                    dist[i] = dist[node] + graph[node][i];
                    pq.offer(new int[] {i, dist[i]});
                }
            }
        }
        return dist;
    }
}
