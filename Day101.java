//Position of the Set Bit

class Solution {
    public int findPosition(int n) {
        if (n <= 0 || (n & (n - 1)) != 0) return -1; // not exactly one set bit
        int pos = 1;
        while ((n & 1) == 0) {
            n >>= 1;
            pos++;
        }
        return pos;
    }
}
