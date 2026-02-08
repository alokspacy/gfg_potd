// Maximum Product Subarray

class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;

        int result = arr[0];

        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        
        for (int i = 1; i < n; i++) {
            int temp = maxEndingHere;

            maxEndingHere = Math.max(arr[i], Math.max(arr[i] * maxEndingHere, arr[i] * minEndingHere));
            minEndingHere = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * minEndingHere));

            result = Math.max(result, maxEndingHere);
        }
        
        return result;
    }
}
