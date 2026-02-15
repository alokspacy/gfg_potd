// Chocolate Distribution Problem

import java.util.*;

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        if (m == arr.size()) {
            return Collections.max(arr) - Collections.min(arr);
        }
      
        Collections.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i + m - 1 < arr.size(); i++) {
            int diff = arr.get(i + m - 1) - arr.get(i);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}
