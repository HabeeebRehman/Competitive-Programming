public class Q4 {
    static class UnionFind {
        int[] parent, rank;
        int count;

        UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        parent[id] = id;
                        count++;
                    }
                }
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

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
                return true;
            }
            return false;
        }
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : directions) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of Islands: " + numIslands(grid)); // Output: 3
    }
}
