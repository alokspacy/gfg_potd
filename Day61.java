// Length of Longest Cycle in a Graph

class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] adj = new int[V];
        Arrays.fill(adj, -1);
        for (int[] e : edges) adj[e[0]] = e[1];

        boolean[] vis = new boolean[V];
        int ans = -1;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                int[] time = new int[V];
                Arrays.fill(time, -1);
                int curr = i, t = 0;
                while (curr != -1 && !vis[curr]) {
                    vis[curr] = true;
                    time[curr] = t++;
                    curr = adj[curr];
                }
                if (curr != -1 && time[curr] != -1) {
                    ans = Math.max(ans, t - time[curr]);
                }
            }
        }
        return ans;
    }
}
