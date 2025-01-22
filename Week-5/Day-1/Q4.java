import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 0, 1, 0}};
        System.out.println(isConnected(graph));
    }

    public static boolean isConnected(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int[][] graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }
}
