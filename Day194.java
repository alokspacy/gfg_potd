// Pairs with Less Than K Diff

import java.util.Arrays;

class Solution {
    public static int countPairs(int[] arr, int k) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        int n = arr.length;
        int count = 0;
        int left = 0;
        
        // Step 2: Expand the right pointer
        for (int right = 0; right < n; right++) {
            // Shrink the left pointer until difference is strictly less than k
            while (arr[right] - arr[left] >= k) {
                left++;
            }
            // Number of valid pairs ending at index 'right'
            count += (right - left);
        }
        
        return count;
    }
}
