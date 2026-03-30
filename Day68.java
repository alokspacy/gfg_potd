// Minimum cost to connect all houses in a city

import java.util.*;

class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;
        boolean[] visited = new boolean[n];
        int cost = 0;
        int count = 0;

        // Min-heap storing {distance, houseIndex}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0}); // start from house 0 with cost 0

        while (count < n) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (visited[u]) continue;

            visited[u] = true;
            cost += d;
            count++;

            // Add all edges from u to unvisited houses
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(houses[u][0] - houses[v][0]) +
                               Math.abs(houses[u][1] - houses[v][1]);
                    pq.offer(new int[]{dist, v});
                }
            }
        }
        return cost;
    }
}
