// Max Xor Subarray of size K

class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        
        int currXor = 0;
        for (int i = 0; i < k; i++) {
            currXor ^= arr[i];
        }
        
        int maxXor = currXor;

        for (int i = k; i < n; i++) {
            currXor ^= arr[i - k]; 
            currXor ^= arr[i];     
            maxXor = Math.max(maxXor, currXor);
        }
        
        return maxXor;
    }
}
