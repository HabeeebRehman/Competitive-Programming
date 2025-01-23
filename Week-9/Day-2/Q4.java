import java.util.*;

public class Q4 {
    private static final int INF = Integer.MAX_VALUE / 2;

    public static int minCostToConnectNodes(int[][] cost) {
        int n = cost.length;
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[1][0] = 0; 
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) { 
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0) { // If node v is not in the set
                            dp[mask | (1 << v)][v] = Math.min(dp[mask | (1 << v)][v], dp[mask][u] + cost[u][v]);
                        }
                    }
                }
            }
        }

        int result = INF;
        for (int i = 1; i < n; i++) {
            result = Math.min(result, dp[(1 << n) - 1][i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] cost = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("Minimum cost to connect nodes: " + minCostToConnectNodes(cost)); // Output: 80
    }
}
