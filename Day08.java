//Stream First Non-repeating

import java.util.*;

class Solution {
    public String firstNonRepeating(String s) {
        int n = s.length();
        int[] freq = new int[26]; // frequency of each character
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);

            // Remove all repeating characters from the front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            if (q.isEmpty()) {
                result.append('#');
            } else {
                result.append(q.peek());
            }
        }
        return result.toString();
    }
}
