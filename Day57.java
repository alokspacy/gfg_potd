// Largest BST

class Solution {
    static class Info {
        int sz, min, max;
        boolean isBST;
        Info(int sz, int min, int max, boolean isBST) {
            this.sz = sz; this.min = min; this.max = max; this.isBST = isBST;
        }
    }

    static int ans;

    static int largestBst(Node root) {
        ans = 0;
        post(root);
        return ans;
    }

    static Info post(Node n) {
        if (n == null) return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);

        Info L = post(n.left), R = post(n.right);

        if (L.isBST && R.isBST && n.data > L.max && n.data < R.min) {
            int sz = L.sz + R.sz + 1;
            ans = Math.max(ans, sz);
            return new Info(sz, Math.min(n.data, L.min), Math.max(n.data, R.max), true);
        }
        return new Info(Math.max(L.sz, R.sz), 0, 0, false);
    }
}
