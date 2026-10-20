// Largest with Same Parity Adjacent Swaps

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0;

        while (i < n) {
            int j = i;
            while (j + 1 < n && (arr[j + 1] % 2) == (arr[i] % 2)) {
                j++;
            }

            Arrays.sort(arr, i, j + 1);
            for (int l = i, r = j; l < r; l++, r--) {
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }

            i = j + 1;
        }

        ArrayList<Integer> res = new ArrayList<>(n);
        for (int x : arr) res.add(x);
        return res;
    }
}
