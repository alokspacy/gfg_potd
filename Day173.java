// Smallest Non-Zero Number

class Solution {
    public int find(int[] arr) {
        // Start from the end, assuming the minimum non-negative value is 0
        int x = 0;
        
        for (int i = arr.length - 1; i >= 0; i--) {
            // Reverse the operation: x_old = (x_new + arr[i] + 1) / 2
            // Adding 1 before integer division performs the ceiling operation
            x = (x + arr[i] + 1) / 2;
        }
        
        return x;
    }
}
