// Coverage of all Zeros in a Binary Matrix

class Solution {
    public int findCoverage(int[][] mat) {
        int totalCoverage = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        
        // Traverse through each cell of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                // Process only if the current cell is 0
                if (mat[i][j] == 0) {
                    
                    // 1. Check Up direction
                    for (int r = i - 1; r >= 0; r--) {
                        if (mat[r][j] == 1) {
                            totalCoverage++;
                            break; // Found a 1, move to next direction
                        }
                    }
                    
                    // 2. Check Down direction
                    for (int r = i + 1; r < rows; r++) {
                        if (mat[r][j] == 1) {
                            totalCoverage++;
                            break; 
                        }
                    }
                    
                    // 3. Check Left direction
                    for (int c = j - 1; c >= 0; c--) {
                        if (mat[i][c] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    
                    // 4. Check Right direction
                    for (int c = j + 1; c < cols; c++) {
                        if (mat[i][c] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                }
                
            }
        }
        
        return totalCoverage;
    }
}
