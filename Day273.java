// Palindrome with Replacement

class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        int prev = -1, sum = 0;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            int j = n - 1 - i;
            char a = s.charAt(i), b = s.charAt(j);
            char c;
            if (a == '?') c = b;
            else if (b == '?' || a == b) c = a;
            else return -1;

            if (c != '?') {
                if (prev != -1) sum += Math.abs(c - prev);
                prev = c;
            }
        }
        return 2 * sum;
    }
}

