// Longest Consecutive Path in Binary tree

/* Structure of Binary Tree Node
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

class Solution {
    private int maxLen;

    public int longestConsecutive(Node root) {
        if (root == null) return -1;
        
        maxLen = 0;
        dfs(root, null, 0);
        
        // Return maxLen if a valid sequence of length >= 2 exists, otherwise -1
        return maxLen > 1 ? maxLen : -1;
    }

    private void dfs(Node node, Node parent, int curLen) {
        if (node == null) return;

        // If current node's value is parent's value + 1, extend the path
        if (parent != null && node.data == parent.data + 1) {
            curLen++;
        } else {
            curLen = 1; // Reset sequence starting at current node
        }

        // Update maximum length found
        maxLen = Math.max(maxLen, curLen);

        // Recurse for left and right children
        dfs(node.left, node, curLen);
        dfs(node.right, node, curLen);
    }
}
