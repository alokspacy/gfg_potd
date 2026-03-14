// Top View of Binary Tree

import java.util.*;

class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Map to store first node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS: stores node and its horizontal distance
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            Node node = cur.node;
            int hd = cur.hd;

            // Record the first node at this horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            // Add children with updated horizontal distances
            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        // Collect results from leftmost to rightmost
        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }
}

// Helper class to store node and horizontal distance
class Pair {
    Node node;
    int hd;
    Pair(Node n, int h) {
        node = n;
        hd = h;
    }
}
