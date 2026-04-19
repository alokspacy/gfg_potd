// Check for Power

class Solution {
    public boolean isPower(int x, int y) {
        if (y == 1) return true;   // x^0 = 1 for all x
        if (x == 1) return y == 1; // only 1^k = 1

        long val = 1;
        while (val < y) {
            val *= x;
            if (val == y) return true;
        }
        return false;
    }
}
