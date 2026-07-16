// Numbers with Given Digit Sum

import java.util.Arrays;

class Solution {
    // Memoization table: dp[n][sum]
    private int[][] dp;

    public int countWays(int n, int sum) {
        // Base edge case: sum of digits cannot exceed 9 * n
        if (sum < 1 || sum > 9 * n) {
            return -1;
        }

        // Initialize memoization table with -1
        dp = new int[n + 1][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursive helper
        int ans = countWaysHelper(n, sum, true);
        
        // If no valid numbers are found, return -1
        return ans == 0 ? -1 : ans;
    }

    private int countWaysHelper(int temp_n, int temp_sum, boolean isFirstDigit) {
        // Base Cases
        if (temp_n == 0) {
            return temp_sum == 0 ? 1 : 0;
        }
        if (temp_sum < 0) {
            return 0;
        }

        // If already computed (only for non-first digit states to keep the state space simple, 
        // or we can just memoize directly as isFirstDigit is true only once)
        if (!isFirstDigit && dp[temp_n][temp_sum] != -1) {
            return dp[temp_n][temp_sum];
        }

        int limitStart = isFirstDigit ? 1 : 0;
        int ans = 0;

        // Try placing every valid digit at the current position
        for (int d = limitStart; d <= 9; d++) {
            if (temp_sum - d >= 0) {
                ans += countWaysHelper(temp_n - 1, temp_sum - d, false);
            }
        }

        // Store the result in the DP table (only for general states where isFirstDigit is false)
        if (!isFirstDigit) {
            dp[temp_n][temp_sum] = ans;
        }

        return ans;
    }
}
