//Two Equal Sum Subarrays

class Solution {
    public boolean canSplit(int arr[]) {
        long total = 0;
        for (int num : arr) total += num;

        // If total sum is odd, can't split into two equal halves
        if (total % 2 != 0) return false;

        long half = total / 2;
        long prefix = 0;

        for (int i = 0; i < arr.length - 1; i++) { 
            prefix += arr[i];
            if (prefix == half) return true;
        }
        return false;
    }
}
