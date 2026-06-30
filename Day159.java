// Minimum Insert and Delete to Convert

import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        // Map each element of b to its index for quick lookup
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        // Transform a into a list of indices based on b
        List<Integer> filtered = new ArrayList<>();
        for (int x : a) {
            if (map.containsKey(x)) {
                filtered.add(map.get(x));
            }
        }

        // Find LIS of the filtered list
        List<Integer> tails = new ArrayList<>();
        for (int x : filtered) {
            int idx = Collections.binarySearch(tails, x);
            if (idx < 0) idx = -(idx + 1);
            if (idx == tails.size()) {
                tails.add(x);
            } else {
                tails.set(idx, x);
            }
        }

        int L = tails.size();
        return (a.length - L) + (b.length - L);
    }
}
