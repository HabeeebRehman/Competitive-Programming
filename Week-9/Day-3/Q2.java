import java.util.*;

public class Q2 {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return false;

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public static int kruskalsMST(int n, int[][] edges) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int[] edge : edges) {
            pq.add(new Edge(edge[0], edge[1], edge[2]));
        }

        UnionFind uf = new UnionFind(n);
        int mstWeight = 0;
        int edgeCount = 0;

        while (!pq.isEmpty() && edgeCount < n - 1) {
            Edge edge = pq.poll();
            if (uf.union(edge.src, edge.dest)) {
                mstWeight += edge.weight;
                edgeCount++;
            }
        }

        return (edgeCount == n - 1) ? mstWeight : -1; // Return -1 if MST not possible
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1, 10}, {0, 2, 6}, {0, 3, 5}, {1, 3, 15}, {2, 3, 4}};
        System.out.println("MST Weight: " + kruskalsMST(n, edges)); // Output: 19
    }
}
