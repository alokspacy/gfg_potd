package gfg_potd;

import java.util.*;

class Solution {
    public int maxPeople(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // compute left visibility using stack
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                left[i] += 1 + left[st.pop()];
            }
            if (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                // blocked, stop
            }
            st.push(i);
        }

        // compute right visibility using stack
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                right[i] += 1 + right[st.pop()];
            }
            if (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                // blocked, stop
            }
            st.push(i);
        }

        int maxVisible = 1;
        for (int i = 0; i < n; i++) {
            maxVisible = Math.max(maxVisible, 1 + left[i] + right[i]);
        }
        return maxVisible;
    }
}