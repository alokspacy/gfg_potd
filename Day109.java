// Max Profit from Two Machines

import java.util.*;

class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        // Store (difference, index)
        List<int[]> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(new int[]{Math.abs(a[i] - b[i]), i});
        }
        
        // Sort by absolute difference descending
        tasks.sort((p, q) -> q[0] - p[0]);
        
        int profit = 0;
        int countA = 0, countB = 0;
        
        for (int[] t : tasks) {
            int i = t[1];
            if ((a[i] >= b[i] && countA < x) || countB >= y) {
                profit += a[i];
                countA++;
            } else {
                profit += b[i];
                countB++;
            }
        }
        
        return profit;
    }
}
