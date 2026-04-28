//Longest Repeating Character Replacement

class Solution {
    public int longestSubstr(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxCount = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxCount = Math.max(maxCount, freq[idx]);

            // shrink if more than k replacements needed
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
