// Closest in BST

class Solution {
    public static int minDiff(Node root, int k) {
        int minDiff = Integer.MAX_VALUE;
        while (root != null) {
            minDiff = Math.min(minDiff, Math.abs(root.data - k));
            if (root.data == k) {
                return 0;
            } else if (root.data > k) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return minDiff;
    }
}
