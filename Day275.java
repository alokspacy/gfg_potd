// Trace Path

class Solution {
    public boolean isPossible(int n, int m, String s) {
        int hc=0,vc=0,minr=0,maxr=0,minc=0,maxc=0;
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='L'){
                hc++;
            }
            else if(s.charAt(i)=='R'){
                hc--;
            }
            else if(s.charAt(i)=='U'){
                vc++;
            }
            else{
                vc--;
            }
            minr=Math.min(minr,vc);
            maxr=Math.max(maxr,vc);
            minc=Math.min(minc,hc);
            maxc=Math.max(maxc,hc);

        }
        if(maxr-minr < n && maxc-minc < m)
        return true;
        return false;
        
    }
}
