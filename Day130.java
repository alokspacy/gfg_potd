// Express as Consecutive Number Sum

class Solution {
    public boolean isSumOfConsecutive(int n) {
        // A number can be expressed as sum of consecutive integers
        // if it is NOT a power of 2
        return (n & (n - 1)) != 0;
    }
}
