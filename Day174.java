// Longest Bitonic Subarray

class Solution {
    public int bitonic(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        int[] inc = new int[n];
        int[] dec = new int[n];
        
        // 1. Length of increasing subarray ending at all indexes
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }
        
        // 2. Length of decreasing subarray starting at all indexes
        dec[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            } else {
                dec[i] = 1;
            }
        }
        
        // 3. Find the maximum length of the bitonic subarray
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, inc[i] + dec[i] - 1);
        }
        
        return maxLength;
    }
}
