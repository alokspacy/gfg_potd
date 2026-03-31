// Buy Stock with Transaction Fee

class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        int hold = -arr[0]; // if we buy on day 0
        int cash = 0;       // no stock initially
        
        for (int i = 1; i < n; i++) {
            hold = Math.max(hold, cash - arr[i]);
            cash = Math.max(cash, hold + arr[i] - k);
        }
        return cash;
    }
}
