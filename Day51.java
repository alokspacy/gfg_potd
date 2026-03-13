// Generate IP Addresses

import java.util.*;

class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int idx, List<String> parts, List<String> res) {
        if (parts.size() == 4) {
            if (idx == s.length()) res.add(String.join(".", parts));
            return;
        }
        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            String seg = s.substring(idx, idx + len);
            if ((seg.length() > 1 && seg.charAt(0) == '0') || Integer.parseInt(seg) > 255) continue;
            parts.add(seg);
            backtrack(s, idx + len, parts, res);
            parts.remove(parts.size() - 1);
        }
    }
}
