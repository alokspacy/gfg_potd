//Count Spanning Trees in a Graph

class Solution {
    public int countSpanTree(int n, int[][] edges) {
        // Step 1: Build Laplacian matrix
        int[][] lap = new int[n][n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            lap[u][u]++;
            lap[v][v]++;
            lap[u][v]--;
            lap[v][u]--;
        }

        // Step 2: Create reduced matrix (remove last row & col)
        int[][] mat = new int[n-1][n-1];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                mat[i][j] = lap[i][j];
            }
        }

        // Step 3: Compute determinant
        return Math.abs(determinant(mat));
    }

    // Gaussian elimination for determinant
    private int determinant(int[][] mat) {
        int n = mat.length;
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = mat[i][j];

        double det = 1.0;
        for (int i = 0; i < n; i++) {
            // Find pivot
            int pivot = i;
            for (int j = i; j < n; j++) {
                if (Math.abs(a[j][i]) > Math.abs(a[pivot][i])) {
                    pivot = j;
                }
            }
            if (Math.abs(a[pivot][i]) < 1e-9) return 0;

            // Swap rows if needed
            if (pivot != i) {
                double[] tmp = a[i];
                a[i] = a[pivot];
                a[pivot] = tmp;
                det *= -1;
            }

            det *= a[i][i];
            double val = a[i][i];
            for (int j = i; j < n; j++) a[i][j] /= val;

            for (int j = i+1; j < n; j++) {
                double factor = a[j][i];
                for (int k = i; k < n; k++) {
                    a[j][k] -= factor * a[i][k];
                }
            }
        }
        return (int)Math.round(det);
    }
}
