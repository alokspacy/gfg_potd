// Max min Height

class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Arrays.stream(arr).min().getAsInt();
        int high = low + k; 

        int ans = low;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAchieve(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;  
            } else {
                high = mid - 1; 
            }
        }
        return ans;
    }

    private boolean canAchieve(int[] arr, int k, int w, int target) {
        int n = arr.length;
        int[] diff = new int[n + 1]; 
        int used = 0, curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i]; 
            int height = arr[i] + curr;
            if (height < target) {
                int need = target - height;
                used += need;
                if (used > k) return false;
                curr += need;
                if (i + w <= n) diff[i + w] -= need;
            }
        }
        return true;
    }
}
