// Sort Two Parts Sorted

class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;

        // Find break point: jahan pehla sorted part khatam hota hai
        int k = 0;
        while (k + 1 < n && arr[k] <= arr[k + 1]) {
            k++;
        }

        // k+1 se second sorted part start hota hai
        int i = 0, j = k + 1, idx = 0;
        int[] temp = new int[n];

        // Merge both sorted parts
        while (i <= k && j < n) {
            if (arr[i] <= arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }

        while (i <= k) temp[idx++] = arr[i++];
        while (j < n) temp[idx++] = arr[j++];

        // Copy back
        for (int x = 0; x < n; x++) {
            arr[x] = temp[x];
        }
    }
}
