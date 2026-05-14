// Search for Subarray

import java.util.*;

class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length, m = b.length;

        // Step 1: Build LPS array for b[]
        int[] lps = new int[m];
        int len = 0, i = 1;
        while (i < m) {
            if (b[i] == b[len]) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }

        // Step 2: KMP search in a[]
        i = 0; // index for a[]
        int j = 0; // index for b[]
        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;
                if (j == m) {
                    result.add(i - j); // match found
                    j = lps[j - 1];   // continue searching
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }
}
