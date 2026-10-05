// Your Social Network

import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // n is the total number of users (size of arr is n - 1)
        int n = arr.length + 1;
        
        // Process each user i from 2 to n
        for (int i = 2; i <= n; i++) {
            int curr = i;
            int distance = 0;
            
            // Traverse the path from user i up to user 1
            while (curr > 1) {
                // arr[curr - 2] gives the immediate friend of 'curr'
                curr = arr[curr - 2];
                distance++;
                
                ArrayList<Integer> tuple = new ArrayList<>();
                tuple.add(i);         // Starting user
                tuple.add(curr);      // Reachable user
                tuple.add(distance);  // Number of links followed
                
                result.add(tuple);
            }
        }
        
        // Sort/order requirements:
        // The problem asks to process users i from 2 to n, and for each i, 
        // list reachable users j in increasing order of j (1 <= j < i).
        // Since each user i has a path where node numbers strictly decrease 
        // (as each friend has a smaller user number than current user), 
        // traversing the path yields j in decreasing order. 
        // Sorting each user's reachable set by j in increasing order handles this:
        
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        int i = 0;
        while (i < result.size()) {
            int startUser = result.get(i).get(0);
            int j = i;
            while (j < result.size() && result.get(j).get(0) == startUser) {
                j++;
            }
            // Add reachable entries for user startUser in reverse order (increasing j)
            for (int k = j - 1; k >= i; k--) {
                finalResult.add(result.get(k));
            }
            i = j;
        }
        
        return finalResult;
    }
}
