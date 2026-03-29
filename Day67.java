// Partitions with Given Difference

class Solution {
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // Check feasibility
        if ((diff + totalSum) % 2 != 0) return 0;
        int target = (diff + totalSum) / 2;

        return countSubsets(arr, target);
    }

    private int countSubsets(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        // Base case: one way to make sum 0 (empty subset)
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                dp[i][sum] = dp[i - 1][sum]; // exclude current element
                if (arr[i - 1] <= sum) {
                    dp[i][sum] += dp[i - 1][sum - arr[i - 1]]; // include current element
                }
            }
        }
        return dp[n][target];
    }
}
