// Count Indices That Escape Array

class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (isGood(i, arr, state)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isGood(int i, int[] arr, int[] state) {
        int curr = i;
        java.util.ArrayList<Integer> path = new java.util.ArrayList<>();
        
        while (curr >= 0 && curr < arr.length) {
            if (state[curr] == 2) {
                for (int node : path) state[node] = 2;
                return true;
            }
            if (state[curr] == 3 || state[curr] == 1) {
                for (int node : path) state[node] = 3;
                return false;
            }
            
            state[curr] = 1;
            path.add(curr);
            
            int jump = arr[curr];
            if (jump == 0) {
                for (int node : path) state[node] = 3;
                return false;
            }
            
            curr += jump;
        }
        
        for (int node : path) state[node] = 2;
        return true;
    }
}

