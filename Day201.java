// Largest Odd Squares with Limited 1s

import java.util.ArrayList;

class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        // Step 1: Precompute 2D Prefix Sum Array
        int[][] pref = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j] 
                                   + pref[i][j + 1] 
                                   + pref[i + 1][j] 
                                   - pref[i][j];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Step 2: Process each query
        for (int[] q : queries) {
            int r = q[0];
            int c = q[1];

            // Maximum possible radius without exceeding matrix boundaries
            int maxS = Math.min(Math.min(r, n - 1 - r), Math.min(c, m - 1 - c));

            int low = 0, high = maxS;
            int ans = -1;

            // Binary search for the maximum valid radius
            while (low <= high) {
                int mid = low + (high - low) / 2;

                int r1 = r - mid, c1 = c - mid;
                int r2 = r + mid, c2 = c + mid;

                int countOnes = pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] 
                              - pref[r2 + 1][c1] + pref[r1][c1];

                if (countOnes <= k) {
                    ans = 2 * mid + 1; // valid side length
                    low = mid + 1;     // try expanding further
                } else {
                    high = mid - 1;    // shrink search range
                }
            }

            result.add(ans);
        }

        return result;
    }
}
