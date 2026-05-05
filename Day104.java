//Sum of XOR of all pairs

class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long ans = 0;
        
        // Check bits up to 17 since arr[i] <= 1e5 < 2^17
        for (int b = 0; b < 17; b++) {
            long cnt1 = 0;
            for (int x : arr) {
                if ((x & (1 << b)) != 0) cnt1++;
            }
            long cnt0 = n - cnt1;
            ans += cnt1 * cnt0 * (1L << b);
        }
        
        return ans;
    }
}
