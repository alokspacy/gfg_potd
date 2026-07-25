// Max Sum Square Sub-Matrix of Size k

class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;
        
        // Step 1: Build a 2D Prefix Sum array (1-indexed for easy boundary handling)
        int[][] pref = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1] 
                           + pref[i - 1][j] 
                           + pref[i][j - 1] 
                           - pref[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // Step 2: Iterate over every possible k x k sub-matrix
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= n; j++) {
                int currentSum = pref[i][j] 
                               - pref[i - k][j] 
                               - pref[i][j - k] 
                               + pref[i - k][j - k];
                
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
