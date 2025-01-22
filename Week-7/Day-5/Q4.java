import java.util.*;

public class Q4 {
    public static void kosaraju(int n, List<List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs1(i, graph, visited, stack);
            }
        }

        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                transpose.get(v).add(u);
            }
        }

        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs2(node, transpose, visited, component);
                System.out.println("SCC: " + component);
            }
        }
    }

    private static void dfs1(int node, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs1(neighbor, graph, visited, stack);
            }
        }
        stack.push(node);
    }

    private static void dfs2(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs2(neighbor, graph, visited, component);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; 
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(2);
        graph.get(2).add(1);
        graph.get(1).add(0);
        graph.get(0).add(3);
        graph.get(3).add(4);

        kosaraju(n, graph);
    }
}
