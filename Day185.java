// Complete Binary Tree Traversal with Array Input

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length;
        int index = 0;
        int levelSize = 1;

        while (index < n) {
            ArrayList<Integer> currentLevel = new ArrayList<>();
            
            // Extract nodes belonging to the current level
            for (int i = 0; i < levelSize && index < n; i++) {
                currentLevel.add(arr[index++]);
            }
            
            // Sort elements of the current level in ascending order
            Collections.sort(currentLevel);
            
            result.add(currentLevel);
            
            // Next level has at most twice the number of nodes
            levelSize *= 2;
        }

        return result;
    }
}
