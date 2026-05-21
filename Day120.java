// Check if All Bits Set

class Solution {
    public boolean isBitSet(int n) {
        if (n == 0) return false; 
        // If n+1 is a power of 2, then n is all 1s in binary
        return ( (n & (n + 1)) == 0 );
    }
}
