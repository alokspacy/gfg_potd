// Koko Eating Bananas

class Solution {
    public int kokoEat(int[] arr, int k) {
        int left = 1;
        int right = 0;
        for (int bananas : arr) {
            right = Math.max(right, bananas);
        }

        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(arr, k, mid)) {
                ans = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        return ans;
    }

    private boolean canFinish(int[] arr, int k, int speed) {
        long hours = 0;
        for (int bananas : arr) {
            hours += (bananas + speed - 1) / speed; 
            if (hours > k) return false; 
        }
        return hours <= k;
    }
}
