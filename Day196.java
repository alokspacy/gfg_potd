// Minimum Increment or Double Operations to Convert

class Solution {
    public int countMinOperations(int arr[]) {
        int totalIncrements = 0;
        int maxDoubles = 0;

        for (int num : arr) {
            int currentDoubles = 0;

            while (num > 0) {
                // If odd, we need an increment operation
                if (num % 2 != 0) {
                    totalIncrements++;
                    num--;
                }
                // If even and greater than 0, we perform a divide operation
                if (num > 0) {
                    num /= 2;
                    currentDoubles++;
                }
            }

            // Keep track of the maximum double operations required by any element
            maxDoubles = Math.max(maxDoubles, currentDoubles);
        }

        return totalIncrements + maxDoubles;
    }
}
