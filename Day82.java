// Next Smallest Palindrome

class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        int[] res = num.clone();

        // Step 1: Mirror left to right
        for (int i = 0; i < n / 2; i++) {
            res[n - 1 - i] = res[i];
        }

        // Step 2: Check if mirrored is greater
        if (!isGreater(res, num)) {
            // Increment middle
            int carry = 1;
            int mid = n / 2;
            int left = (n % 2 == 0) ? mid - 1 : mid;
            int right = mid;

            while (left >= 0 && carry > 0) {
                int val = res[left] + carry;
                res[left] = val % 10;
                res[right] = res[left];
                carry = val / 10;
                left--;
                right++;
            }

            // If carry remains, prepend 1 and append 1
            if (carry > 0) {
                int[] ans = new int[n + 1];
                ans[0] = 1;
                ans[n] = 1;
                for (int i = 0; i < n; i++) ans[i + 1] = res[i];
                return ans;
            }
        }
        return res;
    }

    private static boolean isGreater(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) return true;
            if (a[i] < b[i]) return false;
        }
        return false;
    }
}
