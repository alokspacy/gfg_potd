// Maximize Number of 1's

class Solution {
    public int maxOnes(int arr[], int k) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLen = 0;
        
        while (right < arr.length) {
            // Expand window
            if (arr[right] == 0) {
                zeroCount++;
            }
            
            // Shrink window if too many zeros
            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        
        return maxLen;
    }
}
