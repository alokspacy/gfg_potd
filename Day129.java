// Replace with XOR of Adjacent

class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        if (n < 2) return; // edge case
        
        int[] res = new int[n];
        
        // first element
        res[0] = arr[0] ^ arr[1];
        
        // middle elements
        for (int i = 1; i < n - 1; i++) {
            res[i] = arr[i - 1] ^ arr[i + 1];
        }
        
        // last element
        res[n - 1] = arr[n - 2] ^ arr[n - 1];
        
        // copy back to arr
        for (int i = 0; i < n; i++) {
            arr[i] = res[i];
        }
    }
}
