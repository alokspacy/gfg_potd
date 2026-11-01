// Largest Sum Cycle

class Solution {
    long maxCycleSum = -1;

    public void dfs(int node, int[] Edge, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        if (Edge[node] != -1) {
            int adj = Edge[node];
            if (!vis[adj]) {
                dfs(adj, Edge, vis, pathVis);
            } else if (pathVis[adj]) {
                // Cycle detected, compute the sum
                int curr = adj;
                long currentSum = 0;
                do {
                    currentSum += curr;
                    curr = Edge[curr];
                } while (curr != adj);

                maxCycleSum = Math.max(maxCycleSum, currentSum);
            }
        }

        pathVis[node] = false;
    }

    public long largestSumCycle(int N, int[] Edge) {
        boolean[] vis = new boolean[N];
        boolean[] pathVis = new boolean[N];
        maxCycleSum = -1;

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(i, Edge, vis, pathVis);
            }
        }

        return maxCycleSum;
    }
}
