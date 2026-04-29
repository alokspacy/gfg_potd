// Min Swaps to Group 1s

class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int countOnes = 0;
        for (int x : arr) countOnes += x;
        if (countOnes == 0) return -1;

        // sliding window of size countOnes
        int windowOnes = 0;
        for (int i = 0; i < countOnes; i++) {
            windowOnes += arr[i];
        }
        int maxOnes = windowOnes;

        for (int i = countOnes; i < n; i++) {
            windowOnes += arr[i] - arr[i - countOnes];
            maxOnes = Math.max(maxOnes, windowOnes);
        }

        return countOnes - maxOnes;
    }
}
