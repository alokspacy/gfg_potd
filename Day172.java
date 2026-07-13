// Rearrange the Array

import java.util.*;

class Solution {
    public int minOperations(int[] b) {
        int n = b.length;
        boolean[] visited = new boolean[n + 1];
        long ans = 1;
        long MOD = 1000000007;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int curr = i;
                long cycleSize = 0;
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = b[curr - 1];
                    cycleSize++;
                }
                ans = (ans * (cycleSize / gcd(ans, cycleSize))) % MOD;
            }
        }
        return (int) ans;
    }

    private long gcd(long a, long b) {
        while (b > 0) {
            a %= b;
            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}
