// Max sum in the configuration

class Solution {
    int maxSum(int[] arr) {
        int n = arr.length;
        
        // Step 1: total sum of elements
        int sum = 0;
        for (int num : arr) sum += num;
        
        // Step 2: initial value for configuration
        int currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += i * arr[i];
        }
        
        // Step 3: try all rotations
        int maxVal = currVal;
        for (int i = 1; i < n; i++) {
            // recurrence relation
            currVal = currVal - (sum - arr[i-1]) + arr[i-1] * (n-1);
            maxVal = Math.max(maxVal, currVal);
        }
        
        return maxVal;
    }
}
