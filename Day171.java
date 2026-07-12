// Max Amount by Selling K Tickets

class Solution {

    public int maxAmount(int[] arr, int k) {

        long MOD = 1_000_000_007;

        

        // Find the maximum element in the array to set the binary search upper bound

        int maxVal = 0;

        for (int num : arr) {

            maxVal = Math.max(maxVal, num);

        }

        

        // Binary search to find the minimum price threshold

        int low = 0, high = maxVal;

        int threshold = 0;

        

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (countTickets(arr, mid) >= k) {

                threshold = mid; // Try a higher threshold to sell fewer or equal to k tickets

                low = mid + 1;

            } else {

                high = mid - 1;

            }

        }

        

        long totalEarnings = 0;

        long ticketsSold = 0;

        

        // Calculate earnings for all values strictly greater than the threshold

        for (int num : arr) {

            if (num > threshold) {

                long count = num - threshold;

                ticketsSold += count;

                // Sum of arithmetic progression from (threshold + 1) to num

                long sum = (count * (num + (threshold + 1))) / 2;

                totalEarnings = (totalEarnings + sum) % MOD;

            }

        }

        

        // Fill the remaining required tickets using the exact threshold value

        long remainingTickets = k - ticketsSold;

        if (remainingTickets > 0 && threshold > 0) {

            totalEarnings = (totalEarnings + (remainingTickets * threshold)) % MOD;

        }

        

        return (int) totalEarnings;

    }

    

    // Helper function to count how many tickets can be sold at a price >= mid

    private long countTickets(int[] arr, int mid) {

        if (mid == 0) return Long.MAX_VALUE; // Prevent infinite matching at 0

        long count = 0;

        for (int num : arr) {

            if (num >= mid) {

                count += (num - mid + 1);

            }

        }

        return count;

    }

}
