// Max Adjacent Diffs Sum with 1 Replacements

class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        // dp0 = best sum up to index i when arr[i] is kept
        // dp1 = best sum up to index i when arr[i] is replaced by 1
        int dp0 = 0, dp1 = 0;

        for (int i = 1; i < n; i++) {
            int ndp0 = Math.max(dp0 + Math.abs(arr[i] - arr[i - 1]),
                                dp1 + Math.abs(arr[i] - 1));
            int ndp1 = Math.max(dp0 + Math.abs(1 - arr[i - 1]),
                                dp1); // |1 - 1| = 0
            dp0 = ndp0;
            dp1 = ndp1;
        }

        return Math.max(dp0, dp1);
    }
}
