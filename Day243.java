// Longest Matching in Dictionary with Removals
class Solution {
    static String findLongestWord(String S, List<String> d) {
        String ans = "";
        Collections.sort(d);
        
        for(String word : d) {
            if(word.length()>ans.length() && isPresent(word, S)) {
                ans = word;
            }
        }
        
        return ans;
    }
    
    static boolean isPresent(String word, String S) {
        int i=0, j=0;
        
        while(i<word.length() && j<S.length()) {
            if(word.charAt(i) == S.charAt(j)) {
                i++;
            }
            j++;
        }
        if(i==word.length()) {
            return true;
        }
        return false;
    }
}
