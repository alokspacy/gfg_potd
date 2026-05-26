// Minimum Toggle to Partition

class Solution {
    int minToggle(int[] arr) {
        int n = arr.length;
        
        // prefix count of 1s
        int[] prefixOnes = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixOnes[i + 1] = prefixOnes[i] + (arr[i] == 1 ? 1 : 0);
        }
        
        // suffix count of 0s
        int[] suffixZeros = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixZeros[i] = suffixZeros[i + 1] + (arr[i] == 0 ? 1 : 0);
        }
        
        int minToggles = Integer.MAX_VALUE;
        // try partition at every index
        for (int i = 0; i <= n; i++) {
            int toggles = prefixOnes[i] + suffixZeros[i];
            minToggles = Math.min(minToggles, toggles);
        }
        
        return minToggles;
    }
}
