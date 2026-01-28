//Count Subset with target sum

import java.util.*;

class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        int mid = n / 2;

        // Left half
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        // Right half
        int[] right = Arrays.copyOfRange(arr, mid, n);

        // Generate all subset sums for left and right halves
        List<Integer> leftSums = generateSums(left);
        List<Integer> rightSums = generateSums(right);

        // Count frequency of right sums
        Map<Integer, Integer> freq = new HashMap<>();
        for (int sum : rightSums) {
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        // Count valid subsets
        int count = 0;
        for (int sum : leftSums) {
            int need = k - sum;
            if (freq.containsKey(need)) {
                count += freq.get(need);
            }
        }

        return count;
    }

    // Generate all subset sums of given array
    private List<Integer> generateSums(int[] nums) {
        List<Integer> sums = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n; // 2^n subsets
        for (int mask = 0; mask < total; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                }
            }
            sums.add(sum);
        }
        return sums;
    }
}
