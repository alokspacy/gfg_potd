// Find the closest pair from two arrays

import java.util.*;

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int n = arr1.length, m = arr2.length;
        int i = 0, j = m - 1;
        int diff = Integer.MAX_VALUE;
        int res1 = 0, res2 = 0;

        while (i < n && j >= 0) {
            int sum = arr1[i] + arr2[j];
            int currDiff = Math.abs(sum - x);

            if (currDiff < diff) {
                diff = currDiff;
                res1 = arr1[i];
                res2 = arr2[j];
            }

            if (sum > x) {
                j--;
            } else {
                i++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(res1);
        ans.add(res2);
        return ans;
    }
}
