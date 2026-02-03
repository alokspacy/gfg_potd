// generate permutations of an array

import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, result);
        return result;
    }

    private static void backtrack(int[] arr, int index, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.length) {
            ArrayList<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);  // choose
            backtrack(arr, index + 1, result);  // explore
            swap(arr, i, index);  // un-choose (backtrack)
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
