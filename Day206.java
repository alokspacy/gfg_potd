// Min Product Subset

class Solution {
    public int minProd(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int negCount = 0;
        int zeroCount = 0;
        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        int prod = 1;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            if (num < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, num);
            } else {
                minPos = Math.min(minPos, num);
            }
            prod *= num;
        }

        // Case 1: No negative numbers
        if (negCount == 0) {
            if (zeroCount > 0) return 0;
            return minPos;
        }

        // Case 2: Even count of negative numbers (exclude the largest negative)
        if (negCount % 2 == 0) {
            prod /= maxNeg;
        }

        return prod;
    }
}
