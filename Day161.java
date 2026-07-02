// Check Subset sum divisible by k

class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        boolean[] dp = new boolean[k];
        for (int num : arr) {
            boolean[] next_dp = new boolean[k];
            next_dp[num % k] = true;
            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    next_dp[r] = true;
                    next_dp[(r + num) % k] = true;
                }
            }
            for (int r = 0; r < k; r++) {
                if (next_dp[r]) dp[r] = true;
            }
            if (dp[0]) return true;
        }
        return dp[0];
    }
}
