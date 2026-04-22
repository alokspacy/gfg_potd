//Mean of range in array

import java.util.*;

class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        
        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            long sum = prefix[r + 1] - prefix[l];
            int len = r - l + 1;
            ans.add((int)(sum / len)); // floor division
        }
        return ans;
    }
}
