// Max Product Subsequence of Size K

class Solution {

    public int maxProduct(int[] arr, int k) {

        int n = arr.length;

        Arrays.sort(arr);

 

        // If k equals the array length, we must take all elements

        if (k == n) {

            long prod = 1;

            for (int x : arr) prod *= x;

            return (int) prod;

        }

 

        // If all elements are negative and k is odd, the result will be negative.

        // To maximize a negative product, we need the smallest absolute values

        // (i.e., the largest numbers at the end of the sorted array).

        if (arr[n - 1] <= 0 && k % 2 != 0) {

            long prod = 1;

            for (int i = n - 1; i >= n - k; i--) {

                prod *= arr[i];

            }

            return (int) prod;

        }

 

        // Otherwise, we can achieve a positive (or zero) product.

        // We use two pointers to compare pairs from the left (negatives) and right (positives).

        int left = 0;

        int right = n - 1;

        long maxProd = 1;

 

        // If k is odd, we must pick at least one positive number to keep the product positive.

        // The safest choice is the largest positive number available.

        if (k % 2 != 0) {

            maxProd *= arr[right];

            right--;

            k--;

        }

 

        // Now k is even. Compare pairs of negatives vs pairs of positives.

        while (k > 0) {

            long leftPair = (long) arr[left] * arr[left + 1];

            long rightPair = (long) arr[right] * arr[right - 1];

 

            if (leftPair > rightPair) {

                maxProd *= leftPair;

                left += 2;

            } else {

                maxProd *= rightPair;

                right -= 2;

            }

            k -= 2;

        }

 

        return (int) maxProd;

    }

}
