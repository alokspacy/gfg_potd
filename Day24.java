// The Painter's Partition Problem-II

class Solution {
    public int minTime(int[] arr, int k) {
        int low = 0, high = 0;
        for (int x : arr) {
            low = Math.max(low, x); 
            high += x;             
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canPaint(arr, k, mid)) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }
        return low;
    }
    
    private boolean canPaint(int[] arr, int k, int maxTime) {
        int painters = 1, curr = 0;
        for (int x : arr) {
            if (curr + x <= maxTime) {
                curr += x;
            } else {
                painters++;
                curr = x;
                if (painters > k) return false;
            }
        }
        return true;
    }
}
