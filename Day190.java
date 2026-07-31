// Subsets with Products of Distinct Primes

class Solution {
    public int countSubsets(int[] arr) {
        long MOD = 1_000_000_007;
        
        // 10 prime numbers <= 30
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        
        // Count frequencies of each number in arr
        int[] freq = new int[31];
        for (int num : arr) {
            freq[num]++;
        }
        
        // dp[mask] = number of ways to form product corresponding to mask
        long[] dp = new long[1 << 10];
        dp[0] = 1; // Base case: 1 way to have empty product
        
        for (int i = 2; i <= 30; i++) {
            if (freq[i] == 0) continue;
            
            // Check if 'i' is square-free and calculate its prime mask
            int mask = 0;
            boolean isSquareFree = true;
            int temp = i;
            
            for (int j = 0; j < 10; j++) {
                int count = 0;
                while (temp % primes[j] == 0) {
                    count++;
                    temp /= primes[j];
                }
                if (count > 1) {
                    isSquareFree = false;
                    break;
                }
                if (count == 1) {
                    mask |= (1 << j);
                }
            }
            
            // Skip numbers that have repeated prime factors (e.g., 4, 8, 9, 12, etc.)
            if (!isSquareFree) continue;
            
            // Update DP array backwards to avoid using same element twice
            for (int prevMask = (1 << 10) - 1; prevMask >= 0; prevMask--) {
                if ((prevMask & mask) == 0 && dp[prevMask] > 0) {
                    dp[prevMask | mask] = (dp[prevMask | mask] + dp[prevMask] * freq[i]) % MOD;
                }
            }
        }
        
        // Sum all combinations with mask > 0 (must have at least one prime)
        long totalSubsets = 0;
        for (int mask = 1; mask < (1 << 10); mask++) {
            totalSubsets = (totalSubsets + dp[mask]) % MOD;
        }
        
        // Handle 1s: each '1' can be included or excluded (2^freq[1] ways)
        long powOfTwo = 1;
        for (int i = 0; i < freq[1]; i++) {
            powOfTwo = (powOfTwo * 2) % MOD;
        }
        
        return (int) ((totalSubsets * powOfTwo) % MOD);
    }
}
