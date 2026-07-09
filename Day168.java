// Count Pairs Divisible By K

class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] remainderCount = new int[k];
        for (int num : arr) {
            remainderCount[((num % k) + k) % k]++;
        }
        
        int count = 0;
        
        count += (remainderCount[0] * (remainderCount[0] - 1)) / 2;
        
        for (int i = 1; i < (k + 1) / 2; i++) {
            count += remainderCount[i] * remainderCount[k - i];
        }
        
        if (k % 2 == 0) {
            count += (remainderCount[k / 2] * (remainderCount[k / 2] - 1)) / 2;
        }
        
        return count;
    }
}
