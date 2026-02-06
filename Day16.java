// Happiest Triplet

import java.util.*;

class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[3];

        while (i < a.length && j < b.length && k < c.length) {
            int x = a[i], y = b[j], z = c[k];
            int maxVal = Math.max(x, Math.max(y, z));
            int minVal = Math.min(x, Math.min(y, z));
            int diff = maxVal - minVal;
            int sum = x + y + z;

            // Update best triplet
            if (diff < minDiff || (diff == minDiff && sum < minSum)) {
                minDiff = diff;
                minSum = sum;
                result[0] = x;
                result[1] = y;
                result[2] = z;
            }

            // Move pointer of the minimum element
            if (minVal == x) i++;
            else if (minVal == y) j++;
            else k++;
        }

        // Sort in decreasing order before returning
        Arrays.sort(result);
        int[] ans = new int[]{result[2], result[1], result[0]};
        return ans;
    }
}
