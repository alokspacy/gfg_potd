//Opposite Sign Pair Reduction

import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        ArrayList<Integer> stack = new ArrayList<>();
        for (int x : arr) {
            while (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);
                // Opposite signs
                if ((top > 0 && x < 0) || (top < 0 && x > 0)) {
                    if (Math.abs(top) == Math.abs(x)) {
                        stack.remove(stack.size() - 1); // discard both
                        x = 0; // mark as discarded
                        break;
                    } else if (Math.abs(top) > Math.abs(x)) {
                        // replace both with top
                        x = top;
                        stack.remove(stack.size() - 1);
                        continue; // recheck with new x
                    } else {
                        // replace both with x
                        stack.remove(stack.size() - 1);
                        continue; // recheck with new x
                    }
                }
                break; // not opposite signs, stop
            }
            if (x != 0) stack.add(x);
        }
        return stack;
    }
}
