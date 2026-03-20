// Predecessor and Successor

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node pre = null, suc = null;
        Node curr = root;
        
        // Find predecessor
        while (curr != null) {
            if (curr.data >= key) {
                curr = curr.left;
            } else {
                pre = curr;
                curr = curr.right;
            }
        }
        
        curr = root;
        // Find successor
        while (curr != null) {
            if (curr.data <= key) {
                curr = curr.right;
            } else {
                suc = curr;
                curr = curr.left;
            }
        }
        
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(suc);
        return ans;
    }
}
