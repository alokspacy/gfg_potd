// Equalize the Towers

import java.util.*;

class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;

        int[][] towers = new int[n][2];
        for (int i = 0; i < n; i++) {
            towers[i][0] = heights[i];
            towers[i][1] = cost[i];
        }
        
        Arrays.sort(towers, (a, b) -> Integer.compare(a[0], b[0]));
        
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += towers[i][1];
        }
        
        long half = (totalCost + 1) / 2;
        int targetHeight = towers[0][0];
        long prefix = 0;
        
        for (int i = 0; i < n; i++) {
            prefix += towers[i][1];
            if (prefix >= half) {
                targetHeight = towers[i][0];
                break;
            }
        }

        long minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost += (long)Math.abs(towers[i][0] - targetHeight) * towers[i][1];
        }
        
        return (int)minCost;
    }
}
