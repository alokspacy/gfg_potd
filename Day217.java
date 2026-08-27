// Largest Rectangle with Column Swaps

class Solution {
    int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] heights = new int[m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) heights[j] += 1;
                else heights[j] = 0;
            }

            int[] sorted = heights.clone();
            // sort descending
            Arrays.sort(sorted);
            for (int left = 0, right = m - 1; left < right; left++, right--) {
                int temp = sorted[left];
                sorted[left] = sorted[right];
                sorted[right] = temp;
            }

            for (int j = 0; j < m; j++) {
                int area = sorted[j] * (j + 1);
                result = Math.max(result, area);
            }
        }

        return result;
    }
}
