// Largest Subsquare Surrounded by X

class Solution {
    int largestSubsquare(char mat[][]) {
        // code here
        int row[][] = new int[mat.length][mat[0].length];
        int col[][] = new int[mat.length][mat[0].length];
        
        int rowCount = 0, colCount = 0;
        for(int r=0; r<mat.length; r++){
            for(int c=0; c<mat[0].length; c++){
                rowCount = mat[r][c] == 'X' ? ++rowCount : 0;
                colCount = mat[c][r] == 'X' ? ++colCount : 0;
                row[r][c] = rowCount;
                col[c][r] = colCount;
            }
        }
        
        int result = 0;
        
        for(int r=mat.length-1; r>=0; r--){
            for(int c=mat[0].length-1; c>=0; c--){
                int size = Math.min(row[r][c], col[r][c]);
                
                while(size > result){
                    if((r - size+1) >= 0 && (c - size+1) >= 0 && 
                    row[r][c] >= size && col[r][c] >= size &&
                    row[r - size+1][c] >= size && col[r][c - size+1] >= size){
                        result = size;
                        break;
                    }else{
                        size--;
                    }
                }
            }
        }
        
        return result;
        
    }
};
