// Count Tree Paths With Limited Max Edge Weight

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    // Disjoint Set Union (DSU) structure to manage connected components
    static class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        boolean union(int rootI, int rootJ) {
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
                return true;
            }
            return false;
        }
    }

    // Helper class to store query value alongside its original index
    static class Query implements Comparable<Query> {
        int val;
        int index;

        Query(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Query other) {
            return Integer.compare(this.val, other.val);
        }
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        // 1. Sort edges by weight in ascending order
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        // 2. Wrap queries with original indices and sort them
        int qLen = queries.length;
        Query[] qArr = new Query[qLen];
        for (int i = 0; i < qLen; i++) {
            qArr[i] = new Query(queries[i], i);
        }
        Arrays.sort(qArr);

        DSU dsu = new DSU(n);
        int edgeIdx = 0;
        int numEdges = edges.length;
        int currentPaths = 0;

        Integer[] results = new Integer[qLen];

        // 3. Process queries offline
        for (int i = 0; i < qLen; i++) {
            int qVal = qArr[i].val;
            int qIdx = qArr[i].index;

            // Add all edges with weight <= current query value
            while (edgeIdx < numEdges && edges[edgeIdx][2] <= qVal) {
                int u = edges[edgeIdx][0];
                int v = edges[edgeIdx][1];

                int rootU = dsu.find(u);
                int rootV = dsu.find(v);

                if (rootU != rootV) {
                    currentPaths += dsu.size[rootU] * dsu.size[rootV];
                    dsu.union(rootU, rootV);
                }
                edgeIdx++;
            }
            results[qIdx] = currentPaths;
        }

        return new ArrayList<>(Arrays.asList(results));
    }
}
