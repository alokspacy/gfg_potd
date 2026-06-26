// Count Matching Subsequences

class Solution {
    public static int countWays(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int MOD = 1000000007;

        // dp[i][j] stores the count of s2[0...j-1] as a subsequence of s1[0...i-1]
        int[][] dp = new int[n + 1][m + 1];

        // An empty s2 is a subsequence of any prefix of s1 exactly once
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Include s1[i-1] or skip it
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                } else {
                    // Must skip s1[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}
