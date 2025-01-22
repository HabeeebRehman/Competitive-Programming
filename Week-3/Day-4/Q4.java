import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);
    }

    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inStack = new HashSet<>();

        for (Integer node : adjList.keySet()) {
            if (!visited.contains(node) && dfs(node, visited, inStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, Set<Integer> visited, Set<Integer> inStack) {
        visited.add(node);
        inStack.add(node);

        for (int neighbor : adjList.get(node)) {
            if (inStack.contains(neighbor)) return true;
            if (!visited.contains(neighbor) && dfs(neighbor, visited, inStack)) {
                return true;
            }
        }
        inStack.remove(node);
        return false;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        
        System.out.println(graph.hasCycle()); // Should print true
    }
}
