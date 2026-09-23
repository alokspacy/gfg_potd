// Pyramid Array with Reduce Operations

class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;

        long[] left = new long[n];
        long[] right = new long[n];

        // Maximum possible height at i considering the left side
        left[0] = Math.min(arr[0], 1);

        for (int i = 1; i < n; i++) {
            left[i] = Math.min((long) arr[i], left[i - 1] + 1);
        }

        // Maximum possible height at i considering the right side
        right[n - 1] = Math.min(arr[n - 1], 1);

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min((long) arr[i], right[i + 1] + 1);
        }

        long totalSum = 0;

        for (int x : arr) {
            totalSum += x;
        }

        long maxKept = 0;

        for (int i = 0; i < n; i++) {

            // Peak cannot be larger than the available space
            long maxHeight = Math.min(
                Math.min(left[i], right[i]),
                Math.min(i + 1, n - i)
            );

            // Sum of pyramid of height x is x^2
            long pyramidSum = maxHeight * maxHeight;

            maxKept = Math.max(maxKept, pyramidSum);
        }

        return (int) (totalSum - maxKept);
    }
}


