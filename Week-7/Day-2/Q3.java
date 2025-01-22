public class Q3 {
    static int MOD = 1000000007;

    public static int gridWalking(int n, int m, int x, int y, int k) {
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int steps = 0; steps <= k; steps++) {
                    dp[i][j][steps] = -1;
                }
            }
        }
        return dfs(n, m, x, y, k, dp);
    }

    private static int dfs(int n, int m, int x, int y, int k, int[][][] dp) {
        if (x < 1 || x > n || y < 1 || y > m) return 0; 
        if (k == 0) return 1; 

        if (dp[x][y][k] != -1) return dp[x][y][k]; 

        int ways = 0;
        ways = (ways + dfs(n, m, x - 1, y, k - 1, dp)) % MOD; 
        ways = (ways + dfs(n, m, x + 1, y, k - 1, dp)) % MOD;
        ways = (ways + dfs(n, m, x, y - 1, k - 1, dp)) % MOD;
        ways = (ways + dfs(n, m, x, y + 1, k - 1, dp)) % MOD;

        dp[x][y][k] = ways;
        return ways;
    }
}
