// Check if an Array is Max Heap

class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        // Check only non-leaf nodes
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            
            // If left child exists and violates max-heap property
            if (left < n && arr[i] < arr[left]) return false;
            
            // If right child exists and violates max-heap property
            if (right < n && arr[i] < arr[right]) return false;
        }
        return true;
    }
}
