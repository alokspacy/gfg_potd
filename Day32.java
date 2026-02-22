// Count Subarrays with given XOR

import java.util.*;

class Solution {
    public long subarrayXor(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int px = 0;
        long count = 0;
      
        map.put(0, 1);
        
        for (int num : arr) {
            px ^= num;
          
            int required = px ^ k;
            
            if (map.containsKey(required)) {
                count += map.get(required);
            }
            
            map.put(px, map.getOrDefault(px, 0) + 1);
        }
        
        return count;
    }
}
