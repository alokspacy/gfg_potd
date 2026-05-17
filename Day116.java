// Make the array beautiful

import java.util.*;

class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        List<Integer> stack = new ArrayList<>();
        for (int x : arr) {
            if (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);
                // opposite signs
                if ((top >= 0 && x < 0) || (top < 0 && x >= 0)) {
                    stack.remove(stack.size() - 1); // remove both
                    continue; // discard current x
                }
            }
            stack.add(x);
        }
        return stack;
    }
}
