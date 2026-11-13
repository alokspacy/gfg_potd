// Common Nodes in Two BSTs

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        Node curr1 = r1;
        Node curr2 = r2;
        
        while (true) {
            // Push all left nodes of the first BST
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }
            
            // Push all left nodes of the second BST
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }
            
            // If either stack is empty, we've exhausted one of the trees
            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }
            
            curr1 = s1.peek();
            curr2 = s2.peek();
            
            // If values match, add to result and advance both
            if (curr1.data == curr2.data) {
                result.add(curr1.data);
                s1.pop();
                s2.pop();
                curr1 = curr1.right;
                curr2 = curr2.right;
            } 
            // If curr1's value is smaller, it cannot match any remaining element in tree 2
            else if (curr1.data < curr2.data) {
                s1.pop();
                curr1 = curr1.right;
                curr2 = null; // Keep curr2 fixed for the next iteration
            } 
            // If curr2's value is smaller, it cannot match any remaining element in tree 1
            else {
                s2.pop();
                curr2 = curr2.right;
                curr1 = null; // Keep curr1 fixed for the next iteration
            }
        }
        
        return result;
    }
}
