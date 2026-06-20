// Last Digit of a^b

class Solution {
    public int getLastDigit(String a, String b) {
        // Edge Case 1: If exponent b is "0", any number to power 0 is 1
        if (b.equals("0")) {
            return 1;
        }
        
        // Edge Case 2: If base a is "0", 0 to any non-zero power is 0
        if (a.equals("0")) {
            return 0;
        }

        // Step 1: Find the last digit of base 'a'
        int base = a.charAt(a.length() - 1) - '0';

        // Step 2: Find exponent 'b' modulo 4
        // A number is divisible by 4 if its last two digits are divisible by 4
        int exp = 0;
        if (b.length() == 1) {
            exp = (b.charAt(0) - '0') % 4;
        } else {
            int lastTwoDigits = Integer.parseInt(b.substring(b.length() - 2));
            exp = lastTwoDigits % 4;
        }

        // If b % 4 is 0, we use 4 instead of 0 because cyclicity repeats every 4 steps
        if (exp == 0) {
            exp = 4;
        }

        // Step 3: Compute the last digit
        int result = (int) Math.pow(base, exp);
        
        return result % 10;
    }
}
