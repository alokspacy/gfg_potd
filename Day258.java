// Max Path Sum Between Two Leaves

class Solution {
    int maxSum;

    public int maxPathSum(Node root) {
        if (root == null) {
            return -1;
        }

        maxSum = Integer.MIN_VALUE;
        int val = maxPathSumUtil(root);

        // If root has only one child, maxPathSumUtil won't combine left and right at root,
        // but subtrees might have already updated maxSum.
        if (root.left == null || root.right == null) {
            if (maxSum != Integer.MIN_VALUE) {
                return maxSum;
            }
            return -1; // Fewer than two leaf nodes in total
        }

        return maxSum;
    }

    private int maxPathSumUtil(Node node) {
        if (node == null) {
            return 0;
        }

        // Base case: Leaf node
        if (node.left == null && node.right == null) {
            return node.data;
        }

        // If left subtree is missing, path must continue through the right child
        if (node.left == null) {
            return maxPathSumUtil(node.right) + node.data;
        }

        // If right subtree is missing, path must continue through the left child
        if (node.right == null) {
            return maxPathSumUtil(node.left) + node.data;
        }

        // Both children exist
        int leftSum = maxPathSumUtil(node.left);
        int rightSum = maxPathSumUtil(node.right);

        // Update global max leaf-to-leaf path sum passing through current node
        maxSum = Math.max(maxSum, leftSum + rightSum + node.data);

        // Return max root-to-leaf path sum
        return Math.max(leftSum, rightSum) + node.data;
    }
}
