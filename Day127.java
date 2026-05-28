// Vertical Sum

class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        // Map: column index → sum
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dfs(root, 0, map);

        // Collect results in left-to-right order
        ArrayList<Integer> res = new ArrayList<>();
        for (int sum : map.values()) res.add(sum);
        return res;
    }

    private void dfs(Node node, int col, TreeMap<Integer, Integer> map) {
        if (node == null) return;
        map.put(col, map.getOrDefault(col, 0) + node.data);
        dfs(node.left, col - 1, map);   // left child → col - 1
        dfs(node.right, col + 1, map);  // right child → col + 1
    }
}
