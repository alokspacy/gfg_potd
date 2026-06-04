// Substring with Max Zero-One Diff

class Solution {
    int maxSubstring(String s) {
        int n = s.length();
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            int val = (s.charAt(i) == '0') ? 1 : -1;
            if (val == 1) hasZero = true;

            currSum = Math.max(val, currSum + val);
            maxSum = Math.max(maxSum, currSum);
        }

        return hasZero ? maxSum : -1;
    }
}
