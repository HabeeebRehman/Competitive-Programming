public class Q3 {
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxPath = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, dp));
            }
        }

        return maxPath;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];

        int[] dirs = {-1, 0, 1, 0, -1};
        int maxLength = 1;

        for (int d = 0; d < 4; d++) {
            int x = i + dirs[d], y = j + dirs[d + 1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, x, y, dp));
            }
        }

        dp[i][j] = maxLength;
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };

        System.out.println("Longest Increasing Path: " + longestIncreasingPath(matrix)); // Output: 4
    }
}
