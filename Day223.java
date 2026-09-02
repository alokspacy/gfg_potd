// Unoccupied Computers

class Solution {
	public int solve(int n, String s) {
		// code here
		char ch[] = new char[26];
		int cnt = 0;
		
		for (int i = 0; i<s.length(); i++) {
			int idx = s.charAt(i) - 'A';
			
			if (ch[idx] == '\u0000' && n > 0) {
				n--;
				ch[idx] = 'A';
			} else if (ch[idx] == 'A') {
				n++;
				ch[idx] = 'D';
			} else if (ch[idx] == '\u0000' && n == 0) {
				if (ch[idx] == '\u0000') {
					cnt++;
					ch[idx] = 'N';
				}else{
				    ch[idx] = 'D';
				}
			}
		}
		
		return cnt;
	}
}
