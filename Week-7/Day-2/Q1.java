public class Q1 {
    public static long getWays(int n, int[] coins) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[n];
    }
}
