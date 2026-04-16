//Implement Atoi

class Solution {
    public int myAtoi(String s) {
        int n = s.length(), i = 0;
        // skip leading spaces
        while (i < n && s.charAt(i) == ' ') i++;
        if (i == n) return 0;

        // sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        long num = 0; // use long to detect overflow
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign * num);
    }
}
