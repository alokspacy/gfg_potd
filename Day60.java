// Rotten Oranges

import java.util.*;

class Solution {
    public int orangesRot(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        // Step 1: Count fresh oranges and enqueue all rotten ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        // If no fresh oranges, time = 0
        if (fresh == 0) return 0;
        
        int time = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // Step 2: BFS to rot adjacent fresh oranges
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;
            
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    
                    if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && mat[nx][ny] == 1) {
                        mat[nx][ny] = 2; // rot it
                        q.offer(new int[]{nx, ny});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            
            if (rotted) time++;
        }
        
        // Step 3: If fresh oranges remain, return -1
        return fresh == 0 ? time : -1;
    }
}
