class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        if (n <= 2) return 0; // Not enough bars to trap water
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        // Step 1: Fill leftMax
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        
        // Step 2: Fill rightMax
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        
        // Step 3: Calculate trapped water
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        
        return water;
    }
}
