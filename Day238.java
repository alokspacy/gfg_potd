// Min Edge Reversals for Path

class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        // code here
        // Build adjacency list with weights: 0 for original edge, 1 for reversed edge
               List<List<Pair>> adj = new ArrayList<>();
               for (int i = 0; i <= n; i++) {
                   adj.add(new ArrayList<>());
               }

               for (int[] edge : edges) {
                   int u = edge[0];
                   int v = edge[1];
                   // Original edge u -> v with weight 0
                   adj.get(u).add(new Pair(v, 0));
                   // Reversed edge v -> u with weight 1
                   adj.get(v).add(new Pair(u, 1));
               }

               // Dijkstra's algorithm to find minimum weight path from src to dst
               int[] dist = new int[n + 1];
               Arrays.fill(dist, Integer.MAX_VALUE);
               dist[src] = 0;

               PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
               pq.add(new Pair(src, 0));

               while (!pq.isEmpty()) {
                   Pair current = pq.poll();
                   int u = current.vertex;
                   int d = current.weight;

                   if (d > dist[u]) continue;
                   if (u == dst) return d;

                   for (Pair neighbor : adj.get(u)) {
                       int v = neighbor.vertex;
                       int weight = neighbor.weight;
                       if (dist[u] + weight < dist[v]) {
                           dist[v] = dist[u] + weight;
                           pq.add(new Pair(v, dist[v]));
                       }
                   }
               }

               return -1;
           }

           // Helper class for graph traversal
           private static class Pair {
               int vertex;
               int weight;

               Pair(int vertex, int weight) {
                   this.vertex = vertex;
                   this.weight = weight;
               }
    }
}
