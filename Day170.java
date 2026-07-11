// Longest Possible Route in a Matrix with Hurdles

class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        if (mat == null || mat.length == 0 || mat[0].length == 0 || mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }
        
        int[] max = new int[]{-1};
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        
        dfs(mat, xs, ys, xd, yd, 0, visited, max);
        
        return max[0];
    }

    private void dfs(int[][] mat, int x, int y, int xd, int yd, int pathLength, boolean[][] visited, int[] max) {
        if (x == xd && y == yd) {
            max[0] = Math.max(max[0], pathLength);
            return;
        }
        
        visited[x][y] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < mat.length && ny < mat[0].length && mat[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(mat, nx, ny, xd, yd, pathLength + 1, visited, max);
            }
        }
        
        visited[x][y] = false;
    }
}
