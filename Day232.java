// Values with Equal Array Remainders

class Solution {
    public int sameMod(int[] arr) {
        int n = arr.length;
        
        // Find the overall GCD of absolute differences between adjacent elements
        int g = 0;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            g = gcd(g, diff);
        }

        // If g is 0, all elements in the array are equal -> infinitely many k
        if (g == 0) {
            return -1;
        }

        // Count all positive divisors of g
        int count = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                if (i * i == g) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
