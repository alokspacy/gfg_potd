// Sum of Beauty of All Substrings

class Solution {
    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            for (int j = i; j < n; j++) {
                cnt[s.charAt(j) - 'a']++;
                
                int maxF = Integer.MIN_VALUE;
                int minF = Integer.MAX_VALUE;
                
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        maxF = Math.max(maxF, cnt[k]);
                        minF = Math.min(minF, cnt[k]);
                    }
                }
                
                ans += (maxF - minF);
            }
        }
        return ans;
    }
}
