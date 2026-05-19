// Minimum Multiplications to reach End

import java.util.*;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        if (start == end) return 0;
        
        boolean[] vis = new boolean[1000];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        vis[start] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int val = cur[0], steps = cur[1];
            
            for (int a : arr) {
                int nxt = (val * a) % 1000;
                if (!vis[nxt]) {
                    if (nxt == end) return steps + 1;
                    vis[nxt] = true;
                    q.add(new int[]{nxt, steps + 1});
                }
            }
        }
        return -1;
    }
}
