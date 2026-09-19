// Min Cost To Make Two Strings Identical

class Solution {
    int n;
    int m;
    Integer[][] dp;
    
    public int longestCommonSubSequence(String s1 , String s2 , int i , int j){
        if(i >= n || j >= m){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int maxLen = Integer.MIN_VALUE;
        if(s1.charAt(i) == s2.charAt(j)){
            int case1 = 1 + longestCommonSubSequence(s1 , s2 , i+1 , j+1);
            maxLen = Math.max(maxLen , case1);
        }else{
            int case2 = longestCommonSubSequence(s1 , s2 , i+1 , j);
            int case3 = longestCommonSubSequence(s1 , s2 , i , j+1);
            maxLen = Math.max(maxLen , Math.max(case2 , case3));
        }
        return dp[i][j] = maxLen;
    }
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        // code here
        n = s1.length();
        m = s2.length();
        dp = new Integer[n+1][m+1];
        int result = longestCommonSubSequence(s1 , s2 , 0 , 0);
        
        return costS1*(n-result) + costS2*(m-result);
    }
}
