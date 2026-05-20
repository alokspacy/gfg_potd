// Product Pair

import java.util.*;

class Solution {
    public boolean isProduct(int[] arr, long target) {
        Set<Long> seen = new HashSet<>();
        
        for (int num : arr) {
            long val = num;
            
            // Special case: target == 0
            if (target == 0) {
                if (val == 0) return true; // 0 * anything = 0
                if (seen.contains(0L)) return true; // any number * 0 = 0
            } else {
                // Avoid division by zero
                if (val != 0 && target % val == 0) {
                    long need = target / val;
                    if (seen.contains(need)) return true;
                }
            }
            seen.add(val);
        }
        return false;
    }
}
