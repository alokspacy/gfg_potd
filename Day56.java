// Distribute Candies

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

class Solution {
    private int moves;

    public int distCandy(Node root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(Node node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        moves += Math.abs(left) + Math.abs(right);

        return node.data - 1 + left + right;
    }
}
