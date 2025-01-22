import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {1, 0, 0, 0}};
        System.out.println(hasCycle(graph));
    }

    public static boolean hasCycle(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] recursionStack = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (hasCycleUtil(graph, i, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycleUtil(int[][] graph, int node, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[node]) return true;
        if (visited[node]) return false;
        visited[node] = true;
        recursionStack[node] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && hasCycleUtil(graph, i, visited, recursionStack)) {
                return true;
            }
        }
        recursionStack[node] = false;
        return false;
    }
}
