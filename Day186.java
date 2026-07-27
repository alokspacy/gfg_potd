// Construct a Full Binary Tree

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> mirrorMap = new HashMap<>();

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        int n = pre.length;
        mirrorMap.clear();
        
        // Map elements of preMirror to their corresponding indices for O(1) lookup
        for (int i = 0; i < n; i++) {
            mirrorMap.put(preMirror[i], i);
        }

        return buildTree(pre, preMirror, 0, n - 1, 0, n - 1);
    }

    private Node buildTree(int[] pre, int[] preMirror, int preLow, int preHigh, int mirrorLow, int mirrorHigh) {
        if (preLow > preHigh || mirrorLow > mirrorHigh) {
            return null;
        }

        Node root = new Node(pre[preLow]);

        // If node has no children (leaf node)
        if (preLow == preHigh) {
            return root;
        }

        // The root of the left subtree is the next element in pre[]
        int leftSubtreeRoot = pre[preLow + 1];

        // Find the index of the left subtree root in preMirror[]
        int idx = mirrorMap.get(leftSubtreeRoot);

        // Number of nodes in the left subtree
        int leftSubtreeSize = mirrorHigh - idx + 1;

        // Build left subtree
        root.left = buildTree(pre, preMirror, 
                              preLow + 1, preLow + leftSubtreeSize, 
                              idx, mirrorHigh);

        // Build right subtree
        root.right = buildTree(pre, preMirror, 
                               preLow + leftSubtreeSize + 1, preHigh, 
                               mirrorLow + 1, idx - 1);

        return root;
    }
}
