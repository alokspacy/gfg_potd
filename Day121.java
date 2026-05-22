// 1s Surrounded by 0s

class Solution {
    public int cntOnes(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int trapped = 0;

        // DFS from boundary 1s
        for (int i = 0; i < n; i++) {
            dfs(i, 0, grid, vis);
            dfs(i, m - 1, grid, vis);
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, grid, vis);
            dfs(n - 1, j, grid, vis);
        }

        // Count unvisited 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) trapped++;
            }
        }
        return trapped;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] vis) {
        int n = grid.length, m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m) return;
        if (grid[i][j] == 0 || vis[i][j]) return;
        vis[i][j] = true;
        dfs(i + 1, j, grid, vis);
        dfs(i - 1, j, grid, vis);
        dfs(i, j + 1, grid, vis);
        dfs(i, j - 1, grid, vis);
    }
}
