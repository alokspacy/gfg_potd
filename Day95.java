//Common in 3 Sorted Arrays

import java.util.*;

class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        
        while (i < a.length && j < b.length && k < c.length) {
            // If all three are equal
            if (a[i] == b[j] && b[j] == c[k]) {
                // Avoid duplicates in result
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++; j++; k++;
            }
            // Move the pointer of the smallest element forward
            else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }
        
        return result;
    }
}
