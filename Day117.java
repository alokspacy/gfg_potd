// Maximum Sum Problem

import java.util.*;

class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int maxSum(int n) {
        if (n == 0) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        
        int res = Math.max(n, 
            maxSum(n/2) + maxSum(n/3) + maxSum(n/4));
        
        memo.put(n, res);
        return res;
    }
}
