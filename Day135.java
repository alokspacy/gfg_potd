// Lexicographically smallest after removing k

class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();

        // Correct k
        if ((n & (n - 1)) == 0)  // power of 2
            k = k / 2;
        else
            k = k * 2;

        if (k >= n) return "-1";

        StringBuilder st = new StringBuilder();
        int rem = k;

        for (char c : s.toCharArray()) {
            while (rem > 0 && st.length() > 0 && st.charAt(st.length() - 1) > c) {
                st.deleteCharAt(st.length() - 1);
                rem--;
            }
            st.append(c);
        }

        while (rem > 0) {
            st.deleteCharAt(st.length() - 1);
            rem--;
        }

        return st.toString();
    }
}
