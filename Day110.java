// Palindrome Pairs

import java.util.*;

class Solution {
    public boolean palindromePair(String[] arr) {
        int n = arr.length;
        Map<String, Integer> map = new HashMap<>();
        
        // Store reversed strings in map
        for (int i = 0; i < n; i++) {
            map.put(new StringBuilder(arr[i]).reverse().toString(), i);
        }
        
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            int len = s.length();
            
            for (int cut = 0; cut <= len; cut++) {
                String prefix = s.substring(0, cut);
                String suffix = s.substring(cut);
                
                // Case 1: prefix palindrome → need reversed suffix
                if (isPalindrome(prefix)) {
                    Integer j = map.get(suffix);
                    if (j != null && j != i) return true;
                }
                
                // Case 2: suffix palindrome → need reversed prefix
                if (isPalindrome(suffix)) {
                    Integer j = map.get(prefix);
                    if (j != null && j != i) return true;
                }
            }
        }
        return false;
    }
    
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
