// Count Palindromic Strings with Constraints

class Solution {
    public int palindromicStrings(int n, int k) {
        final long MOD = 1_000_000_007L;
        long ans = 0;

        // pref represents P(k, m) = k * (k-1) * ... * (k-m+1)
        long pref = 1;

        for (int m = 0; 2 * m <= n; m++) {
            if (m > 0) {
                pref = (pref * (k - m + 1)) % MOD;
            }

            // Even length = 2m
            if (m > 0) {
                ans = (ans + pref) % MOD;
            }

            // Odd length = 2m + 1
            if (2 * m + 1 <= n) {
                long odd = (pref * (k - m)) % MOD;
                ans = (ans + odd) % MOD;
            }
        }

        return (int) ans;
    }
}
