// Min Edge Movements to Connect a Graph

class Solution {
    int minEdgesReq(int n, int[][] edges) {
        int m = edges.length;
        
        // A graph with 'n' vertices needs at least 'n - 1' edges to be connected.
        if (m < n - 1) {
            return -1;
        }
        
        // Disjoint Set Union (DSU) implementation
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int components = n;
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            
            if (rootU != rootV) {
                parent[rootU] = rootV;
                components--; // Two components merged into one
            }
        }
        
        // Operations required = number of components - 1
        return components - 1;
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]); // Path compression
    }
}
