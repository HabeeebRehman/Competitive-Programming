import java.util.*;

public class Q3 {
    public static void topologicalSort(int n, List<List<Integer>> graph) {
        int[] inDegree = new int[n];
        for (List<Integer> edges : graph) {
            for (int v : edges) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (topoOrder.size() != n) {
            System.out.println("The graph has a cycle and cannot be topologically sorted.");
        } else {
            System.out.println("Topological Order: " + topoOrder);
        }
    }

    public static void main(String[] args) {
        int n = 6; 
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topologicalSort(n, graph);
    }
}
