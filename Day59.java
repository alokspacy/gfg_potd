// Number of BST From Array

import java.util.*;

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;

        // Step 1: Precompute Catalan numbers
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;

        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - 1 - j];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Step 2: For each element
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) left++;
                else if (arr[j] > arr[i]) right++;
            }

            result.add(catalan[left] * catalan[right]);
        }

        return result;
    }
}
