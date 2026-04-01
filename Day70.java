// Consecutive 1's not allowed

class Solution {
    int countStrings(int n) {
        if (n == 1) return 2;
        if (n == 2) return 3;
        
        long a = 2, b = 3; // dp[1], dp[2]
        long c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return (int)b;
    }
}
