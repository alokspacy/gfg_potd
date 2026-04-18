// Flip to Maximize 1s

class Solution {
    int maxOnes(int[] arr) {
        int n = arr.length;
        int totalOnes = 0;
        for (int x : arr) if (x == 1) totalOnes++;

        // Build gain array and apply Kadane’s algorithm
        int maxGain = Integer.MIN_VALUE, curr = 0;
        for (int x : arr) {
            int val = (x == 0 ? 1 : -1);
            curr = Math.max(val, curr + val);
            maxGain = Math.max(maxGain, curr);
        }

        // If all are 1s, flipping any subarray reduces count
        if (maxGain < 0) return totalOnes;

        return totalOnes + maxGain;
    }
}
