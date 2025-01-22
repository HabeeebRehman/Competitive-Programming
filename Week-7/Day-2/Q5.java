public class Q5 {
    public static int minimumSubsetSumDifference(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][totalSum / 2 + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum / 2; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int maxSumSubset = 0;
        for (int j = totalSum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                maxSumSubset = j;
                break;
            }
        }

        return Math.abs(totalSum - 2 * maxSumSubset);
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 11, 5};
        System.out.println(minimumSubsetSumDifference(nums)); // Output: 1
    }
}
