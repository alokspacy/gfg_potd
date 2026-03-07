// Dice throw

class Solution {
    static int noOfWays(int m, int n, int x) {
        int[][] dp = new int[n + 1][x + 1];
        
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= x; j++) { 
                for (int face = 1; face <= m; face++) {
                    if (j - face >= 0) {
                        dp[i][j] += dp[i - 1][j - face];
                    }
                }
            }
        }
        
        return dp[n][x];
    }
}
