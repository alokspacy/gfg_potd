// Adding Ones

class Solution {

    public ArrayList<Integer> update(int n, int[] updates) {
        int[] mark = new int[n];
        for (int k : updates) {
            mark[k - 1]++;
        }

        ArrayList<Integer> result = new ArrayList<>(n);
        int running = 0;
        Integer boxed = 0;
        for (int i = 0; i < n; i++) {
            if (mark[i] != 0) {
                running += mark[i];
                boxed = running;
            }
            result.add(boxed);
        }
        return result;
    }
}
