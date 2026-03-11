// Sum of subarray minimums

class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        long res = 0; 
        int MOD = (int)1e9 + 7; 

        int[] left = new int[n];  
        int[] right = new int[n]; 

        java.util.Stack<int[]> st1 = new java.util.Stack<>();
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            while (!st1.isEmpty() && st1.peek()[0] > arr[i]) {
                cnt += st1.pop()[1];
            }
            left[i] = cnt;
            st1.push(new int[]{arr[i], cnt});
        }

        java.util.Stack<int[]> st2 = new java.util.Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 1;
            while (!st2.isEmpty() && st2.peek()[0] >= arr[i]) {
                cnt += st2.pop()[1];
            }
            right[i] = cnt;
            st2.push(new int[]{arr[i], cnt});
        }

        for (int i = 0; i < n; i++) {
            res += (long) arr[i] * left[i] * right[i];
        }

        return (int) res;
    }
}
