// Painting the Fence

class Solution {
    int countWays(int n, int k) {
        if (n == 1) return k;
        int same = k, diff = k * (k - 1), total = same + diff;
        for (int i = 3; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }
}
