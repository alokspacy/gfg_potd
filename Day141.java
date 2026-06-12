// Check Repeated Substring with K Replacements

import java.util.*;

class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();
        if (n % k != 0) return false; // must divide evenly

        int m = n / k; // number of blocks
        Map<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i += k) {
            String block = s.substring(i, i + k);
            freq.put(block, freq.getOrDefault(block, 0) + 1);
        }

        // Case 1: all blocks identical
        if (freq.size() == 1) return true;

        // Case 2: exactly two distinct blocks, and one occurs once
        if (freq.size() == 2) {
            for (int count : freq.values()) {
                if (count == 1) return true;
            }
        }

        return false;
    }
}
