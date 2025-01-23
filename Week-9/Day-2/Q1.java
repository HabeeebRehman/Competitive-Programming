import java.util.Arrays;

public class Q1 {
    private static final int INF = Integer.MAX_VALUE / 2;

    public static int tsp(int[][] distance) {
        int n = distance.length;
        int[][] dp = new int[1 << n][n];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[1][0] = 0; // Starting city is always 0

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) { // If city u is in the subset
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0) { // If city v is not in the subset
                            dp[mask | (1 << v)][v] = Math.min(dp[mask | (1 << v)][v],
                                    dp[mask][u] + distance[u][v]);
                        }
                    }
                }
            }
        }

        int result = INF;
        for (int i = 1; i < n; i++) {
            result = Math.min(result, dp[(1 << n) - 1][i] + distance[i][0]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] distance = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("Shortest route distance: " + tsp(distance)); // Output: 80
    }
}
