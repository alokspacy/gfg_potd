// Max Product Subset

class Solution {
    static final int MOD = 1000000007;

    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0] % MOD;  // single element case

        int negCount = 0, zeroCount = 0;
        int maxNeg = Integer.MIN_VALUE;
        long product = 1;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            if (num < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, num); // closest to zero negative
            }
            product = (product * num) % MOD;
        }

        // Case: all zeros
        if (zeroCount == n) return 0;

        // Case: only one negative and rest zeros
        if (negCount == 1 && zeroCount + negCount == n) return 0;

        // If odd negatives, remove the smallest absolute negative
        if (negCount % 2 == 1) {
            product = (product * modInverse(maxNeg, MOD)) % MOD;
        }

        // Normalize result into [0, MOD)
        return (int)((product % MOD + MOD) % MOD);
    }

    // Modular inverse using Fermat's Little Theorem (since MOD is prime)
    private long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private long pow(long base, long exp, int mod) {
        long res = 1;
        base = (base % mod + mod) % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
