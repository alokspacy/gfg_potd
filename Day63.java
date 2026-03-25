// Minimum height roots

import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        if (V == 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }

        // Build adjacency list
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new HashSet<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // Initialize leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }

        int remaining = V;
        while (remaining > 2) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);
                if (adj.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }

            leaves = newLeaves;
        }

        return new ArrayList<>(leaves);
    }
}
