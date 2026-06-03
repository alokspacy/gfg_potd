// Subarray Frequency Count Queries

import java.util.*;

class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        int n = arr.length;
        // Map each value to sorted list of indices where it appears
        HashMap<Integer, ArrayList<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], x = q[2];
            ArrayList<Integer> list = pos.get(x);
            if (list == null) {
                ans.add(0);
                continue;
            }
            // count indices in [l, r] using binary search
            int left = lowerBound(list, l);
            int right = upperBound(list, r);
            ans.add(right - left);
        }
        return ans;
    }
    
    // first index >= target
    private int lowerBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    
    // first index > target
    private int upperBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
