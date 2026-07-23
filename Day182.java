// Check Preorder of BST

import java.util.List;
import java.util.Stack;

class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        int root = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int val : arr) {
            // If we find an element smaller than the root of the current subtree,
            // it violates the BST preorder property.
            if (val < root) {
                return false;
            }

            // Pop elements that are smaller than 'val' and update the root
            while (!stack.isEmpty() && stack.peek() < val) {
                root = stack.pop();
            }

            // Push current element to the stack
            stack.push(val);
        }

        return true;
    }
}
