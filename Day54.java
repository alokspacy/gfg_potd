// K Sum Paths

import java.util.*;

class Solution {
    public int countAllPaths(Node root, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1); // base case: empty path
        return dfs(root, 0, k, prefix);
    }

    private int dfs(Node node, int sum, int k, Map<Integer, Integer> prefix) {
        if (node == null) return 0;

        sum += node.data;
        int cnt = prefix.getOrDefault(sum - k, 0);

        prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        cnt += dfs(node.left, sum, k, prefix);
        cnt += dfs(node.right, sum, k, prefix);
        prefix.put(sum, prefix.get(sum) - 1); // backtrack

        return cnt;
    }
}
