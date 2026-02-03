import java.util.*;

public class Solution {
    public static int subarrayRanges(int[] arr) {
        int n = arr.length;
        long result = sumOfContributions(arr, true) - sumOfContributions(arr, false);
        return (int) result;  // cast safely to int
    }

    // Helper function to calculate contributions
    private static long sumOfContributions(int[] arr, boolean isMax) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n ||
                    (isMax && arr[stack.peek()] < (i < n ? arr[i] : Integer.MAX_VALUE)) ||
                    (!isMax && arr[stack.peek()] > (i < n ? arr[i] : Integer.MIN_VALUE)))) {
                
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                long left = j - k;
                long right = i - j;
                res += (long) arr[j] * left * right;
            }
            stack.push(i);
        }
        return res;
    }
}
