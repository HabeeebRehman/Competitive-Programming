public class Q5 {
    public static int optimalSearchTree(int[] freq) {
        int n = freq.length;
        int[][] dp = new int[n][n];
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + freq[i];
        }

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int root = i; root <= j; root++) {
                    int cost = (root > i ? dp[i][root - 1] : 0) +
                               (root < j ? dp[root + 1][j] : 0) +
                               (prefixSum[j + 1] - prefixSum[i]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] freq = {34, 8, 50};
        System.out.println("Optimal BST Cost: " + optimalSearchTree(freq)); // Output: 142
    }
}
