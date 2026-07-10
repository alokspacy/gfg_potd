// Ways to Express as Sum of Consecutives

class Solution {
    public int getCount(int n) {
        int count = 0;
        for (int i = 2; i * (i + 1) / 2 <= n; i++) {
            if ((n - i * (i + 1) / 2) % i == 0) {
                count++;
            }
        }
        return count;
    }
}
