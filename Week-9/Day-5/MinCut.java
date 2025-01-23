import java.util.*;

public class MinCut {
    static final int INF = Integer.MAX_VALUE;

    static boolean bfs(int[][] rGraph, int s, int t, int[] parent, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[t];
    }

    static int fordFulkerson(int[][] graph, int s, int t, int V) {
        int[][] rGraph = new int[V][V];
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        int[] parent = new int[V];
        int maxFlow = 0;

        while (bfs(rGraph, s, t, parent, V)) {
            int pathFlow = INF;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    static void minCut(int[][] graph, int s, int V) {
        int[][] rGraph = new int[V][V];
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        int[] parent = new int[V];
        int maxFlow = fordFulkerson(graph, s, V - 1, V);
        System.out.println("Maximum Flow (which is equal to minimum cut): " + maxFlow);

        // Find which vertices are reachable from the source
        boolean[] visited = new boolean[V];
        dfs(rGraph, s, visited, V);

        // Print the minimum cut
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (visited[i] && !visited[j] && graph[i][j] > 0) {
                    System.out.println("Edge (" + i + ", " + j + ") is in the minimum cut");
                }
            }
        }
    }

    static void dfs(int[][] rGraph, int u, boolean[] visited, int V) {
        visited[u] = true;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && rGraph[u][v] > 0) {
                dfs(rGraph, v, visited, V);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] graph = new int[][] {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };

        minCut(graph, 0, V);
    }
}
