// Count Sorted Digit Groupings

class Solution {
    public int validGroups(String s) {
        int n = s.length();
        // dp[i][prevSum] = number of valid groupings starting at index i with previous sum prevSum
        Integer[][] dp = new Integer[n + 1][901]; // max sum of 100 digits (all '9') = 900
        return dfs(s, 0, 0, dp);
    }

    private int dfs(String s, int idx, int prevSum, Integer[][] dp) {
        if (idx == s.length()) return 1; // reached end, valid grouping

        if (dp[idx][prevSum] != null) return dp[idx][prevSum];

        int res = 0, sum = 0;
        for (int j = idx; j < s.length(); j++) {
            sum += s.charAt(j) - '0'; // sum of current substring
            if (sum >= prevSum) {
                res += dfs(s, j + 1, sum, dp);
            }
        }
        return dp[idx][prevSum] = res;
    }
}
