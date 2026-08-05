// Subarrays with Sum in Range

class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        return (int) (countLessEqual(arr, r) - countLessEqual(arr, l - 1));
    }

    private long countLessEqual(int[] arr, long target) {
        if (target < 0) return 0;
        
        int n = arr.length;
        long currentSum = 0;
        long count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            // Shrink the window from left if currentSum exceeds target
            while (left <= right && currentSum > target) {
                currentSum -= arr[left];
                left++;
            }

            // All subarrays ending at 'right' starting from 'left' to 'right' are valid
            count += (right - left + 1);
        }

        return count;
    }
}
