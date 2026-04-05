// Target Sum

class Solution {
    public int totalWays(int[] arr, int target) {
        int sum = 0;
        for (int x : arr) sum += x;

        // If impossible, return 0
        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) return 0;

        int P = (sum + target) / 2;
        return countSubsets(arr, P);
    }

    private int countSubsets(int[] arr, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // one way to make sum 0

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
