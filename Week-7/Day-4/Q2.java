public class Q2 {
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String result = "";

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = len == 1 || len == 2 || dp[i + 1][j - 1];
                    if (dp[i][j] && len > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
