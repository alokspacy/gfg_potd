class Solution {
    int findWays(int n) {
        // Odd length can't form valid parentheses
        if (n % 2 != 0) return 0;
        
        int m = n / 2;
        long[] catalan = new long[m + 1];
        catalan[0] = 1;
        
        // DP to compute Catalan numbers
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        
        return (int)catalan[m];
    }
}
