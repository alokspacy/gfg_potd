//Pythagorean Triplet

import java.util.*;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        
        // Step 1: Square and store in set
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
            set.add(arr[i]);
        }
        
        // Step 2: Check all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (set.contains(sum)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
