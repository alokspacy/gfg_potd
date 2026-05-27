class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int lastCovered = -1;  // last index covered so far
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                // router at i covers [i-x, i+x]
                int left = Math.max(0, i - x);
                int right = Math.min(n - 1, i + x);
                
                // if there's a gap between lastCovered+1 and left, it's uncovered
                if (left > lastCovered + 1) return false;
                
                // extend coverage
                lastCovered = right;
            }
        }
        
        // after processing all routers, check if the last room is covered
        return lastCovered >= n - 1;
    }
}
