// Adventure in a Maze

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int MOD = 1_000_000_007;

        int[][] dpPaths = new int[n][n];
        int[][] dpMax = new int[n][n];

        // Base case: starting cell (0, 0)
        dpPaths[0][0] = 1;
        dpMax[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // If the current cell is not reachable, skip it
                if (dpPaths[i][j] == 0 && (i != 0 || j != 0)) {
                    continue;
                }

                // Try moving Right to (i, j + 1)
                if (j + 1 < n && (grid[i][j] == 1 || grid[i][j] == 3)) {
                    dpPaths[i][j + 1] = (dpPaths[i][j + 1] + dpPaths[i][j]) % MOD;
                    dpMax[i][j + 1] = Math.max(dpMax[i][j + 1], dpMax[i][j] + grid[i][j + 1]);
                }

                // Try moving Down to (i + 1, j)
                if (i + 1 < n && (grid[i][j] == 2 || grid[i][j] == 3)) {
                    dpPaths[i + 1][j] = (dpPaths[i + 1][j] + dpPaths[i][j]) % MOD;
                    dpMax[i + 1][j] = Math.max(dpMax[i + 1][j], dpMax[i][j] + grid[i + 1][j]);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(dpPaths[n - 1][n - 1]);
        result.add(dpPaths[n - 1][n - 1] > 0 ? dpMax[n - 1][n - 1] : 0);

        return result;
    }
}
