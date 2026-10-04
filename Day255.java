// Perimeter of Shapes in Binary Matrix

class Solution {
    static int findPerimeter(int[][] mat) {
        // code here
        int p  = 0;
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++){
                if(mat[i][j] == 1){
                    p+=4;
                    
                    if(i+1<n && mat[i+1][j] == 1) p-=2;
                    if(j+1<m && mat[i][j+1] == 1) p-=2;
                }
            }
        }
    return p;
    }
}

