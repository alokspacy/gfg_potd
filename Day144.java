// Minimum Cost to Fill Given Weight

class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int INF = (int)1e9;  // large value
        int[] dp = new int[w + 1];
        
        // Initialize dp
        for (int i = 1; i <= w; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;
        
        // Complete knapsack
        for (int i = 1; i <= w; i++) {
            for (int j = 0; j < n; j++) {
                int packetSize = j + 1;
                if (cost[j] != -1 && packetSize <= i) {
                    dp[i] = Math.min(dp[i], dp[i - packetSize] + cost[j]);
                }
            }
        }
        
        return dp[w] == INF ? -1 : dp[w];
    }
}
