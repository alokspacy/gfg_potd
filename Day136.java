// Non-Attacking Black and White Knights

class Solution {
    public int numOfWays(int n, int m) {
        long total = 1L * n * m * (n * m - 1); // ordered pairs
        long attacks = 0;
        
        int[][] moves = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] mv : moves) {
                    int ni = i + mv[0], nj = j + mv[1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        attacks++;
                    }
                }
            }
        }
        
        return (int)(total - attacks);
    }
}
