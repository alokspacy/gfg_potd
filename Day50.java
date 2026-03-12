// Minimum K Consecutive Bit Flips

class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int[] isFlipped = new int[n];
        int flipCount = 0, res = 0;

        for (int i = 0; i < n; i++) {
            // Remove expired flip effect
            if (i >= k) {
                flipCount -= isFlipped[i - k];
            }

            if ((arr[i] + flipCount) % 2 == 0) {
                if (i + k > n) return -1; // not enough space to flip
                isFlipped[i] = 1;         // mark flip starting here
                flipCount++;
                res++;
            }
        }
        return res;
    }
}
