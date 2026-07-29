// Split Array into Minimum Subsets

import java.util.Arrays;

class Solution {
    int minSubsets(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Sort the array in non-decreasing order
        Arrays.sort(arr);

        int count = 1;
        
        // Count transitions where consecutive sequence breaks
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                count++;
            }
        }

        return count;
    }
}
