// Transform to Sum Tree

class Solution {
    public void toSumTree(Node root) {
        transform(root);
    }

    // Helper function returns sum of subtree (original values)
    private int transform(Node node) {
        if (node == null) return 0;

        // Recursively get sums of left and right subtrees
        int leftSum = transform(node.left);
        int rightSum = transform(node.right);

        // Store original value before updating
        int oldVal = node.data;

        // Update current node’s value to sum of left + right subtree
        node.data = leftSum + rightSum;

        // Return total sum (original value + left + right) for parent use
        return oldVal + node.data;
    }
}
