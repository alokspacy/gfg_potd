// Count increasing Subarrays

class Solution {
    public int countIncreasing(int[] arr) {
        int n = arr.length;
        long count = 0;
        int len = 1; // length of current increasing run

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                // add subarrays from the previous run
                count += (long)len * (len - 1) / 2;
                len = 1; // reset run length
            }
        }
        // add the last run
        count += (long)len * (len - 1) / 2;

        return (int)count;
    }
}
