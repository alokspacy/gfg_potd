// Max Subarray Sum by Removing At Most One

class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int[] fw = new int[n];
        int[] bw = new int[n];

        // Fill forward array (Kadane's)
        fw[0] = arr[0];
        int maxSoFar = fw[0];
        for (int i = 1; i < n; i++) {
            fw[i] = Math.max(arr[i], fw[i - 1] + arr[i]);
            maxSoFar = Math.max(maxSoFar, fw[i]);
        }

        // Fill backward array
        bw[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            bw[i] = Math.max(arr[i], bw[i + 1] + arr[i]);
        }

        // Calculate max sum by skipping at most one element
        int result = maxSoFar;
        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, fw[i - 1] + bw[i + 1]);
        }

        return result;
    }
}
