// Equal Point in Brackets

class Solution {
    public int findIndex(String s) {
        int n = s.length();
        int[] prefixOpen = new int[n + 1];
        int[] suffixClose = new int[n + 1];

        // prefix count of '('
        for (int i = 0; i < n; i++) {
            prefixOpen[i + 1] = prefixOpen[i] + (s.charAt(i) == '(' ? 1 : 0);
        }

        // suffix count of ')'
        for (int i = n - 1; i >= 0; i--) {
            suffixClose[i] = suffixClose[i + 1] + (s.charAt(i) == ')' ? 1 : 0);
        }

        // find first equal point
        for (int k = 0; k <= n; k++) {
            if (prefixOpen[k] == suffixClose[k]) return k;
        }
        return -1; // should not happen if constraints valid
    }
}
