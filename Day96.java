// Smallest window containing 0, 1 and 2

class Solution {
    public int smallestSubstring(String s) {
        int n = s.length();
        int[] count = new int[3]; // counts for '0','1','2'
        int distinct = 0, left = 0, ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - '0';
            if (count[idx] == 0) distinct++;
            count[idx]++;

            while (distinct == 3) {
                ans = Math.min(ans, right - left + 1);
                int leftIdx = s.charAt(left) - '0';
                count[leftIdx]--;
                if (count[leftIdx] == 0) distinct--;
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
