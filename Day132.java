// Pairs with certain difference

import java.util.Arrays;

class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        Arrays.sort(arr);  // sort ascending
        int n = arr.length;
        int sum = 0;

        // Traverse from the end (largest elements)
        for (int i = n - 1; i > 0; ) {
            if (arr[i] - arr[i - 1] < k) {
                // valid pair
                sum += arr[i] + arr[i - 1];
                i -= 2; // skip both elements
            } else {
                i--; // move left
            }
        }
        return sum;
    }
}
