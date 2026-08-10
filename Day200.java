// High Effort vs Low Effort

class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        if (n == 0) return 0;
        if (n == 1) return Math.max(h[0], l[0]);

        int[] dp = new int[n];

        // Base cases
        dp[0] = Math.max(h[0], l[0]);
        dp[1] = Math.max(h[1], dp[0] + l[1]);

        // Fill DP table
        for (int i = 2; i < n; i++) {
            // Option 1: Perform low-effort task today + best till yesterday
            int lowEffort = dp[i - 1] + l[i];

            // Option 2: Perform high-effort task today + best till day i-2 (day i-1 is idle)
            int highEffort = dp[i - 2] + h[i];

            dp[i] = Math.max(lowEffort, highEffort);
        }

        return dp[n - 1];
    }
}
