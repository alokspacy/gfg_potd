// At Least K Occurrences

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstElementKTime(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            // Update the frequency count of the current number
            int count = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, count);

            // Return immediately when an element hits k occurrences
            if (count == k) {
                return num;
            }
        }

        return -1;
    }
}
