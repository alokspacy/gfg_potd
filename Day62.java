// Course Schedule I

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // build adjacency list
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] p : prerequisites) g.get(p[1]).add(p[0]);

        int[] vis = new int[n]; // 0=unvisited, 1=visiting, 2=visited

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0 && hasCycle(g, vis, i)) return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> g, int[] vis, int u) {
        vis[u] = 1; // mark as visiting
        for (int v : g.get(u)) {
            if (vis[v] == 1) return true; // cycle found
            if (vis[v] == 0 && hasCycle(g, vis, v)) return true;
        }
        vis[u] = 2; // mark as visited
        return false;
    }
}
