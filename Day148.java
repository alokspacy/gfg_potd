// Equalize All Prefix Sums

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Using long for prefix sums to avoid any potential integer overflow
        long[] pref = new long[n];
        pref[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + arr[i];
        }
        
        for (int i = 0; i < n; i++) {
            int mid = i / 2;
            long leftSum, rightSum;
            
            if (i % 2 == 1) { // Even number of elements (0 to i)
                leftSum = pref[mid];
                rightSum = pref[i] - pref[mid];
            } else { // Odd number of elements (0 to i)
                leftSum = (mid > 0) ? pref[mid - 1] : 0;
                rightSum = pref[i] - pref[mid];
            }
            
            result.add((int)(rightSum - leftSum));
        }
        
        return result;
    }
}
