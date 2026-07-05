// Max Gap Between Two Same

import java.util.Arrays;

class Solution {
    public int maxCharGap(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        
        int maxGap = -1;
        
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            
            if (firstIndex[charIdx] != -1) {
                int currentGap = i - firstIndex[charIdx] - 1;
                maxGap = Math.max(maxGap, currentGap);
            } else {
                firstIndex[charIdx] = i;
            }
        }
        
        return maxGap;
    }
}
