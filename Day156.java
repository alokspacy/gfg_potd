// Ways to Tile the Floor

class Solution {
    public int countWays(int n, int m) {
        // If the floor height is less than m, we can only place tiles horizontally.
        if (n < m) {
            return 1;
        }
        
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        
        // Base cases
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2; // 1 way all horizontal, 1 way all vertical
            } else {
                dp[i] = (dp[i - 1] + dp[i - m]) % MOD;
            }
        }
        
        return dp[n];
    }
}
