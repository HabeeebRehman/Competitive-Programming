import java.util.*;

public class Q5 {
    public int findConnectedComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int components = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(graph, visited, i);
            }
        }
        
        return components;
    }
    
    private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    dfs(graph, visited, neighbor);
                }
            }
        }
    }
}
