// Minimum Days

class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = p.length;
        
        int high = n;
        int low = 0;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(check(s, p, mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean check(String s, int []p, int k) {
        char []arr = s.toCharArray();
        
        for(int i = 0; i < k; i++) {
            arr[p[i]] = '?';
        }
        
        for(int i = 1; i < p.length; i++) {
            if(arr[i] == arr[i - 1] && arr[i] != '?') {
                return false;
            }
        }
        return true;
    }
}
