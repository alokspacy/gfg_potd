// Huffman Encoding

import java.util.*;

class Solution {
    static class Node {
        int freq;
        int idx;
        Node left, right;

        Node(int f, int i) {
            freq = f;
            idx = i;
            left = right = null;
        }
    }

    static class Compare implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.freq == b.freq) {
                return a.idx - b.idx; // smaller idx first
            }
            return a.freq - b.freq; // smaller freq first
        }
    }

    private void buildCodes(Node root, String code, ArrayList<String> ans) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            ans.add(code);
            return;
        }

        buildCodes(root.left, code + "0", ans);
        buildCodes(root.right, code + "1", ans);
    }

    public ArrayList<String> huffmanCodes(String s, int[] f) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        int n = s.length();

        for (int i = 0; i < n; i++) {
            pq.add(new Node(f[i], i));
        }

        if (n == 1) {
            ArrayList<String> single = new ArrayList<>();
            single.add("0");
            return single;
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left.freq + right.freq, Math.min(left.idx, right.idx));
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        ArrayList<String> ans = new ArrayList<>();
        buildCodes(pq.peek(), "", ans);
        return ans;
    }
}
