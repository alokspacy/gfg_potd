// Max Sum Subarray of Size at least K

class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;
        
        // Step 1: Precompute Kadane's maximum subarray sum ending at each index
        int[] maxSumEndingAt = new int[n];
        maxSumEndingAt[0] = arr[0];
        int currentMax = arr[0];
        
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSumEndingAt[i] = currentMax;
        }
        
        // Step 2: Calculate sum of the first k elements
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int maxResult = windowSum;
        
        // Step 3: Slide the window of length k from index k to n - 1
        for (int i = k; i < n; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            
            // Subarray sum of size at least k ending at index i:
            // either just the k-length window OR the window plus max subarray ending at (i - k)
            int sumWithMoreThanK = windowSum + maxSumEndingAt[i - k];
            
            maxResult = Math.max(maxResult, Math.max(windowSum, sumWithMoreThanK));
        }
        
        return maxResult;
    }
}
