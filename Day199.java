// Largest Zigzag Sequence

class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        if (n == 1) {
            return mat[0][0];
        }

        // dp[j] stores the maximum path sum ending at column j in the current row
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int firstMax = -1, secondMax = -1;
            int maxCol = -1;

            // Find the largest and second-largest path sums from the previous row
            for (int j = 0; j < n; j++) {
                if (dp[j] > firstMax) {
                    secondMax = firstMax;
                    firstMax = dp[j];
                    maxCol = j;
                } else if (dp[j] > secondMax) {
                    secondMax = dp[j];
                }
            }

            // Calculate DP values for the current row
            int[] nextDp = new int[n];
            for (int j = 0; j < n; j++) {
                if (j != maxCol) {
                    nextDp[j] = mat[i][j] + firstMax;
                } else {
                    nextDp[j] = mat[i][j] + secondMax;
                }
            }
            dp = nextDp;
        }

        // Return the maximum sum in the bottom row
        int maxSum = 0;
        for (int val : dp) {
            maxSum = Math.max(maxSum, val);
        }
        return maxSum;
    }
}
