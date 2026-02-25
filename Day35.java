// Longest Subarray with Majority Greater than K

import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
      
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = (arr[i] > k) ? 1 : -1;
        }
  
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            prefixSum += temp[i];
          
            if (prefixSum > 0) {
                maxLen = i + 1;
            }
          
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
      
            if (map.containsKey(prefixSum - 1)) {
                int idx = map.get(prefixSum - 1);
                maxLen = Math.max(maxLen, i - idx);
            }
        }
        
        return maxLen;
    }
}
