// Minimum Cost for n Characters

class Solution {
    public int minCost(int n, int i, int d, int c) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = i;
        
        for (int k = 2; k <= n; k++) {
            if (k % 2 == 0) {
                // Even: insert 1 from k-1 OR copy-paste k/2
                dp[k] = Math.min(dp[k - 1] + i, dp[k / 2] + c);
            } else {
                // Odd: insert 1 from k-1 OR copy-paste (k+1)/2 and delete 1
                dp[k] = Math.min(dp[k - 1] + i, dp[(k + 1) / 2] + c + d);
            }
        }
        
        return (int) dp[n];
    }
}
