// Vertical Tree Traversal

/* 
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // Map: horizontal distance -> list of nodes
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // Queue for BFS: stores node and its horizontal distance
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        // Collect results from leftmost to rightmost
        for (ArrayList<Integer> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}

// Helper class to store node with its horizontal distance
class Pair {
    Node node;
    int hd;
    Pair(Node n, int h) {
        node = n;
        hd = h;
    }
}
