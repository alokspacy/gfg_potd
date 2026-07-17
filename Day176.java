// Max Absolute Diff of Two Subarrays

class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;
        
        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];
        
        // Left-to-Right Kadane's
        int maxSoFar = arr[0], currMax = arr[0];
        int minSoFar = arr[0], currMin = arr[0];
        leftMax[0] = arr[0];
        leftMin[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
            leftMax[i] = maxSoFar;
            
            currMin = Math.min(arr[i], currMin + arr[i]);
            minSoFar = Math.min(minSoFar, currMin);
            leftMin[i] = minSoFar;
        }
        
        // Right-to-Left Kadane's
        maxSoFar = arr[n - 1]; currMax = arr[n - 1];
        minSoFar = arr[n - 1]; currMin = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];
        rightMin[n - 1] = arr[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
            rightMax[i] = maxSoFar;
            
            currMin = Math.min(arr[i], currMin + arr[i]);
            minSoFar = Math.min(minSoFar, currMin);
            rightMin[i] = minSoFar;
        }
        
        // Find the maximum absolute difference by trying all possible split points
        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff1 = Math.abs(leftMax[i] - rightMin[i + 1]);
            int diff2 = Math.abs(rightMax[i + 1] - leftMin[i]);
            maxDiff = Math.max(maxDiff, Math.max(diff1, diff2));
        }
        
        return maxDiff;
    }
}
