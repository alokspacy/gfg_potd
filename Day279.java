// Nth in Concatenated Decimal String

class Solution {
    public char nthCharacter(int n) {
        // code here
        long length = 1;
        long count = 9;
        long start = 1;
        
        while (n > length * count) {
            n -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }
        
        long targetNumber = start + (n - 1)/length;
        
        String numberStr = Long.toString(targetNumber);
        int digitIndex = (int)((n - 1) % length);
        
        return numberStr.charAt(digitIndex);
    }
}
