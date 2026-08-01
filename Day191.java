// Max After m Range Increments

class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // Create difference array of size n + 1
        long[] diff = new long[n + 1];
        int m = a.length;

        // Apply operations in O(1) time each
        for (int i = 0; i < m; i++) {
            diff[a[i]] += k[i];
            diff[b[i] + 1] -= k[i];
        }

        // Compute prefix sums to find the maximum element
        long maxVal = 0;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += diff[i];
            if (currentSum > maxVal) {
                maxVal = currentSum;
            }
        }

        return (int) maxVal;
    }
}
