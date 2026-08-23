// Geek in a Maze

import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int r, c, u, d;
        
        Node(int r, int c, int u, int d) {
            this.r = r;
            this.c = c;
            this.u = u;
            this.d = d;
        }

        @Override
        public int compareTo(Node other) {
            // Prioritize states with fewer total vertical moves (u + d)
            return (this.u + this.d) - (other.u + other.d);
        }
    }

    public int numberOfCells(int r, int c, int maxU, int maxD, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Base cases: invalid start or start position is an obstacle
        if (r < 0 || r >= n || c < 0 || c >= m || mat[r][c] == '#') {
            return 0;
        }

        // Keep track of visited cells to count distinct locations
        boolean[][] visited = new boolean[n][m];
        
        // Keep track of minimum moves used to reach cell (i, j)
        int[][] minUp = new int[n][m];
        int[][] minDown = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(minUp[i], Integer.MAX_VALUE);
            Arrays.fill(minDown[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(r, c, 0, 0));
        
        minUp[r][c] = 0;
        minDown[r][c] = 0;

        int distinctVisitedCount = 0;

        // Direction arrays: Up, Down, Left, Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // Mark as visited when extracted to count unique cells
            if (!visited[curr.r][curr.c]) {
                visited[curr.r][curr.c] = true;
                distinctVisitedCount++;
            }

            // Explore 4-directional neighbors
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] != '#') {
                    int nextU = curr.u + (dr[i] == -1 ? 1 : 0);
                    int nextD = curr.d + (dr[i] == 1 ? 1 : 0);

                    // Check if within allowed upward and downward constraints
                    if (nextU <= maxU && nextD <= maxD) {
                        // Check if this path gives a better (fewer) vertical move count
                        if (nextU < minUp[nr][nc] || nextD < minDown[nr][nc]) {
                            if (nextU < minUp[nr][nc]) minUp[nr][nc] = nextU;
                            if (nextD < minDown[nr][nc]) minDown[nr][nc] = nextD;

                            pq.add(new Node(nr, nc, nextU, nextD));
                        }
                    }
                }
            }
        }

        return distinctVisitedCount;
    }
}
