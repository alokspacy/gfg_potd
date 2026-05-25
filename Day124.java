// Elements in the Range

import java.util.*;

class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // put all elements in a HashSet for O(1) lookup
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);

        // check every number in [start, end]
        for (int i = start; i <= end; i++) {
            if (!set.contains(i)) return false;
        }
        return true;
    }
}
