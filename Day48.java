// Subarrays with First Element Minimum

class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        int[] nextSmaller = new int[n];
        java.util.Arrays.fill(nextSmaller, n);
        
        java.util.Stack<Integer> st = new java.util.Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nextSmaller[i] = st.peek();
            }
            st.push(i);
        }
        
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (nextSmaller[i] - i);
        }
        
        return (int) count;
    }
}
