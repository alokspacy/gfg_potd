// Last Coin in a Game of Alternates

class Solution {
    public int coin(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] >= arr[r]) {
                l++; // remove left coin
            } else {
                r--; // remove right coin
            }
        }
        return arr[l]; // last remaining coin
    }
}
