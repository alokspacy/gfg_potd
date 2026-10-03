// Coils in a Matrix

class Solution {
	public ArrayList<ArrayList<Integer>> formCoils(int n) {
		// code here
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		int size = 4 * n;
		int len = size * size;
		
		int temp[][] = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 1; j <= size; j++) {
				temp[i][j - 1] = i * size + j;
			}
		}
		
		int startRow = 0;
		int startCol = 0;
		int endRow = size - 1;
		int endCol = size - 1;
		
		ArrayList<Integer> ans1 = new ArrayList<>();
		ArrayList<Integer> ans2 = new ArrayList<>();
		boolean isOn = false;
		
		while (startRow < endRow && startCol < endCol) {
			
			// Top - Down
			for (int i = startRow; i <= endRow; i++) {
				if(!isOn){
				    ans1.add(temp[i][startCol]);
				}else{
				    ans2.add(temp[i][startCol]);
				}
			}
			
			// Bottom - Right
			for (int i = startCol + 1; i < endCol; i++) {
				if(!isOn){
				    ans1.add(temp[endRow][i]);
				}else{
				    ans2.add(temp[endRow][i]);
				}
			}
			isOn = !isOn;
			
			// Bottom - Up
			for (int i = endRow; i >= startRow; i--) {
				if(isOn){
				    ans2.add(temp[i][endCol]);
				}else{
				    ans1.add(temp[i][endCol]);
				}
				
			}
			
			// Right - Left
			for (int i = endCol - 1; i >= startCol + 1; i--) {
				if(isOn){
				    ans2.add(temp[startRow][i]);
				}else{
				    ans1.add(temp[startRow][i]);
				}
				
			}
			
			startRow++;
			startCol++;
			endRow--;
			endCol--;
		}
		
		ans.add(ans1);
		ans.add(ans2);
		
		return ans;
	}
}
