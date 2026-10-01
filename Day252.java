// Minimum Time to Finish Project

import java.util.*;

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[n];
        for (int[] dep : dependencies) {
            int u = dep[0];
            int v = dep[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] completionTime = new int[n];
        
        for (int i = 0; i < n; i++) {
            completionTime[i] = duration[i];
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int processedCount = 0;
        int maxProjectTime = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            processedCount++;
            
            maxProjectTime = Math.max(maxProjectTime, completionTime[curr]);
            
            for (int neighbor : adj.get(curr)) {
                // Update completion time for neighbor module
                completionTime[neighbor] = Math.max(completionTime[neighbor], completionTime[curr] + duration[neighbor]);
                
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // If not all modules could be processed, a cycle exists
        if (processedCount < n) {
            return -1;
        }
        
        return maxProjectTime;
    }
}
